package y23.m04.d20;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

public class KeyPressListener implements KeyListener {
    private final int keyCode;
    private final Consumer<KeyEvent> callback;

    public KeyPressListener(int keyCode, Consumer<KeyEvent> callback) {
        this.keyCode = keyCode;
        this.callback = callback;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != keyCode) {
            return;
        }
        callback.accept(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
