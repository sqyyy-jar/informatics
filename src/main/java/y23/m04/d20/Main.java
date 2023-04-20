package y23.m04.d20;

import com.github.sqyyy.jnb.Entrypoint;
import com.github.sqyyy.jnb.Page;

import javax.swing.*;
import java.awt.*;

@Page("23/04/20")
public class Main {
    private static final String METAL_THEME = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String NIMBUS_THEME = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String MOTIF_THEME = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    private static final String GTK_THEME = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    private static final DefaultListModel<String> NAME_LINES = new DefaultListModel<>();

    @Entrypoint
    public static void main(String[] main)
        throws InterruptedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
        IllegalAccessException {
        UIManager.setLookAndFeel(GTK_THEME);
        NAME_LINES.addElement("Hello");
        var frame = new JFrame("InfoCamp");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(1920 / 2 - WIDTH / 2, 1080 / 2 - HEIGHT / 2);
        frame.setResizable(false);
        var tabs = new JTabbedPane();
        addRegistrationTab(tabs);
        addNameListTab(tabs);
        frame.add(tabs);
        frame.setVisible(true);
        for (int i = 0; i < 100; i++) {
            synchronized (NAME_LINES) {
                NAME_LINES.addElement(String.valueOf(i));
            }
            Thread.sleep(50);
        }
    }

    private static void addRegistrationTab(JTabbedPane tabs) {
        var componentWidth = 150;
        var mid = WIDTH / 2 - componentWidth / 2;
        var componentCount = 6;
        var topOffset = HEIGHT / 2 - 30 * (componentCount - 1);
        var panel = new JPanel();
        panel.setLayout(null);
        var nameLabel = new JLabel("Vorname:");
        nameLabel.setText("Vorname:");
        nameLabel.setBounds(mid, topOffset += 30, componentWidth, 25);
        var nameField = new JTextField();
        nameField.setBounds(mid, topOffset += 30, componentWidth, 25);
        var surnameLabel = new JLabel("Nachname:");
        surnameLabel.setBounds(mid, topOffset += 30, componentWidth, 25);
        var surnameField = new JTextField();
        surnameField.setBounds(mid, topOffset += 30, componentWidth, 25);
        var submitButton = new JButton("Registrieren");
        submitButton.setBounds(mid, topOffset += 30, componentWidth, 25);
        var statusMessage = new JLabel();
        statusMessage.setBounds(mid, topOffset += 30, componentWidth, 25);
        submitButton.addActionListener(e -> {
            statusMessage.setForeground(Color.RED);
            statusMessage.setText("Not implemented");
        });
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(surnameLabel);
        panel.add(surnameField);
        panel.add(submitButton);
        panel.add(statusMessage);
        tabs.addTab("Registrierung", panel);
    }

    private static void addNameListTab(JTabbedPane tabs) {
        var panel = new JPanel();
        panel.setLayout(null);
//        var refreshButton = new JButton("Neu laden");
//        refreshButton.setBounds(20, 5, 100, 20);
        var list = new JList<String>();
        list.setModel(NAME_LINES);
//        refreshButton.addActionListener(e -> {
//            list.updateUI();
//        });
        var innerScrollPanel = new JPanel();
        innerScrollPanel.setLayout(new BorderLayout());
        innerScrollPanel.add(list);
        var scrollPane = new JScrollPane(innerScrollPanel);
        scrollPane.setBounds(5, 5, WIDTH - 10, HEIGHT - 70);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar()
            .setUnitIncrement(16);
//        panel.add(refreshButton);
        panel.add(scrollPane);
        tabs.addTab("Namensliste", panel);
    }
}
