package y23.m04.d20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Gui {
    private static final Font FONT = new Font("Default", Font.PLAIN, 24);
    private static final String METAL_THEME = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String NIMBUS_THEME = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String MOTIF_THEME = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    private static final String GTK_THEME = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    private final int width = 1600;
    private final int height = 900;
    private final DefaultListModel<String> nameLines = new DefaultListModel<>();
    private final Management management = new Management();
    private final Path path = Path.of("participants.txt");

    public void start()
        throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!management.loadFromFile(path)) {
            throw new RuntimeException("Could not load from file");
        }
        reloadNameList();
        UIManager.setLookAndFeel(GTK_THEME);
        var frame = new JFrame("InfoCamp");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocation(1920 / 2 - width / 2, 1080 / 2 - height / 2);
        frame.setResizable(false);
        var tabs = new JTabbedPane();
        addRegistrationTab(tabs);
        addNameListTab(tabs);
        frame.add(tabs);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!management.saveToFile(path)) {
                    throw new RuntimeException("Could not save file");
                }
            }
        });
        frame.setVisible(true);
    }

    private void addRegistrationTab(JTabbedPane tabs) {
        var componentWidth = 250;
        var componentHeight = 40;
        var panel = new JPanel();
        panel.setLayout(null);
        var aligner = new CenterGuiAligner(panel, width - 3, height, componentWidth, componentHeight);
        var fill = aligner.addLabel(FONT, "");
        updateFillText(fill);
        fill.setHorizontalAlignment(SwingConstants.CENTER);
        aligner.addLabel(FONT, "Vorname:");
        var nameField = aligner.addTextField(FONT);
        aligner.addLabel(FONT, "Nachname:");
        var surnameField = aligner.addTextField(FONT);
        var submitButton = new JButton("Registrieren");
        submitButton.setFont(FONT);
        aligner.add(submitButton);
        var statusMessage = aligner.addWideLabel(FONT, "", 400);
        statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
        submitButton.addActionListener(e -> {
            if (management.isFilled()) {
                statusMessage.setForeground(Color.RED);
                statusMessage.setText("Keine Plätze mehr verfügbar");
                return;
            }
            var name = nameField.getText();
            var pattern = Pattern.compile("[a-zA-ZäÄüÜöÖß]+");
            if (!pattern.matcher(name)
                .matches()) {
                statusMessage.setForeground(Color.RED);
                statusMessage.setText("Kein valider Vorname");
                return;
            }
            var surname = surnameField.getText();
            if (!pattern.matcher(surname)
                .matches()) {
                statusMessage.setForeground(Color.RED);
                statusMessage.setText("Kein valider Nachname");
                return;
            }
            var participant = new Participant(name, surname);
            if (management.isRegistered(participant)) {
                statusMessage.setForeground(Color.RED);
                statusMessage.setText("Teilnehmer bereits vorhanden");
                return;
            }
            if (!management.addParticipant(participant)) {
                statusMessage.setForeground(Color.RED);
                statusMessage.setText("Unerwarteter Fehler ist aufgetreten");
                return;
            }
            statusMessage.setForeground(Color.GREEN);
            statusMessage.setText("Erfolgreich registriert");
            nameLines.addElement(participant.getSurname() + " " + participant.getName());
            updateFillText(fill);
        });
        aligner.finish();
        tabs.addTab("Registrierung", panel);
        tabs.addChangeListener(e -> updateFillText(fill));
    }

    private void addNameListTab(JTabbedPane tabs) {
        var panel = new JPanel();
        panel.setLayout(null);
        var deleteButton = new JButton("Entfernen");
        deleteButton.setBounds(5, 5, 100, 20);
        var nameSortButton = new JButton("Sortiern (Vorname)");
        nameSortButton.setBounds(106, 5, 150, 20);
        var surnameSortButton = new JButton("Sortiern (Nachname)");
        surnameSortButton.setBounds(257, 5, 150, 20);
        var list = new JList<String>();
        list.setModel(nameLines);
        var innerScrollPanel = new JPanel();
        innerScrollPanel.setLayout(new BorderLayout());
        innerScrollPanel.add(list);
        var scrollPane = new JScrollPane(innerScrollPanel);
        scrollPane.setBounds(5, 25, width - 10, height - 90);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar()
            .setUnitIncrement(16);
        deleteButton.addActionListener(e -> removeParticipants(list));
        surnameSortButton.addActionListener(e -> {
            management.sortBySurname();
            reloadNameList();
        });
        nameSortButton.addActionListener(e -> {
            management.sortByName();
            reloadNameList();
        });
        list.addKeyListener(new KeyPressListener(KeyEvent.VK_DELETE,
            e -> removeParticipants(list)));
        panel.add(deleteButton);
        panel.add(nameSortButton);
        panel.add(surnameSortButton);
        panel.add(scrollPane);
        tabs.addTab("Namensliste", panel);
    }

    private void reloadNameList() {
        nameLines.clear();
        for (int i = 0; i < management.getParticipantCount(); i++) {
            var participant = management.getParticipant(i);
            nameLines.addElement(participant.getSurname() + " " + participant.getName());
        }
    }

    private void removeParticipants(JList<String> list) {
        var startIndex = list.getAnchorSelectionIndex();
        var endIndex = list.getLeadSelectionIndex();
        if (startIndex == -1 || endIndex == -1) {
            return;
        }
        if (startIndex > endIndex) {
            var temp = startIndex;
            startIndex = endIndex;
            endIndex = temp;
        }
        var count = endIndex - startIndex + 1;
        for (int i = 0; i < count; i++) {
            nameLines.remove(startIndex);
            management.removeParticipant(startIndex);
        }
    }

    private void updateFillText(JLabel fill) {
        fill.setText(management.getParticipantCount() + "/" + management.getMaxParticipantCount());
    }
}
