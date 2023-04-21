package y23.m04.d20;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private static final Font FONT = new Font("Default", Font.PLAIN, 24);
    private static final String METAL_THEME = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String NIMBUS_THEME = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String MOTIF_THEME = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    private static final String GTK_THEME = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    private final int width = 1600;
    private final int height = 900;
    private final DefaultListModel<String> nameLines = new DefaultListModel<>();

    public void start()
        throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException,
        InterruptedException {
        UIManager.setLookAndFeel(GTK_THEME);
        nameLines.addElement("Hello");
        var frame = new JFrame("InfoCamp");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocation(1920 / 2 - width / 2, 1080 / 2 - height / 2);
        frame.setResizable(false);
        var tabs = new JTabbedPane();
        addRegistrationTab(tabs);
        addNameListTab(tabs);
        frame.add(tabs);
        frame.setVisible(true);
        for (int i = 0; i < 100; i++) {
            synchronized (nameLines) {
                nameLines.addElement(String.valueOf(i));
            }
            Thread.sleep(50);
        }
    }

    private void addRegistrationTab(JTabbedPane tabs) {
        var componentWidth = 250;
        var componentHeight = 40;
        var panel = new JPanel();
        panel.setLayout(null);
        var aligner = new CenterGuiAligner(panel, width - 3, height - 18, componentWidth, componentHeight);
        aligner.addLabel(FONT, "Vorname:");
        var nameField = aligner.addTextField(FONT);
        aligner.addLabel(FONT, "Nachname:");
        var surnameField = aligner.addTextField(FONT);
        var submitButton = new JButton("Registrieren");
        submitButton.setFont(FONT);
        aligner.add(submitButton);
        var statusMessage = aligner.addLabel(FONT, "");
        submitButton.addActionListener(e -> {
            statusMessage.setForeground(Color.RED);
            statusMessage.setText("Not implemented");
        });
        aligner.finish();
        tabs.addTab("Registrierung", panel);
    }

    private void addNameListTab(JTabbedPane tabs) {
        var panel = new JPanel();
        panel.setLayout(null);
        var list = new JList<String>();
        list.setModel(nameLines);
        var innerScrollPanel = new JPanel();
        innerScrollPanel.setLayout(new BorderLayout());
        innerScrollPanel.add(list);
        var scrollPane = new JScrollPane(innerScrollPanel);
        scrollPane.setBounds(5, 5, width - 10, height - 70);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar()
            .setUnitIncrement(16);
        panel.add(scrollPane);
        tabs.addTab("Namensliste", panel);
    }
}
