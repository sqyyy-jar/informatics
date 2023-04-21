package y23.m04.d20;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CenterGuiAligner {
    private final JPanel panel;
    private final int width;
    private final int height;
    private final int componentWidth;
    private final int componentHeight;
    private final List<Component> components;

    public CenterGuiAligner(JPanel panel, int width, int height, int componentWidth, int componentHeight) {
        this.panel = panel;
        this.width = width;
        this.height = height;
        this.componentWidth = componentWidth;
        this.componentHeight = componentHeight;
        components = new ArrayList<>();
    }

    public JLabel addLabel(Font font, String text) {
        var label = new JLabel(text);
        label.setFont(font);
        label.setSize(componentWidth, componentHeight);
        components.add(label);
        return label;
    }

    public JLabel addWideLabel(Font font, String text, int width) {
        var label = new JLabel(text);
        label.setFont(font);
        label.setSize(width, componentHeight);
        components.add(label);
        return label;
    }

    public JTextField addTextField(Font font) {
        return addTextField(font, "");
    }

    public JTextField addTextField(Font font, String defaultValue) {
        var textField = new JTextField(defaultValue);
        textField.setFont(font);
        textField.setSize(componentWidth, componentHeight);
        components.add(textField);
        return textField;
    }

    public void add(Component component) {
        component.setSize(componentWidth, componentHeight);
        components.add(component);
    }

    public void finish() {
        var topOffset = height / 2 - (componentHeight * components.size() + 5 * (components.size() - 1)) / 2;
        for (var component : components) {
            component.setLocation(width / 2 - component.getWidth() / 2, topOffset);
            topOffset += componentHeight + 5;
            panel.add(component);
        }
    }
}
