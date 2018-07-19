package project.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {

    private Handler handler;

    public KeyboardInput(Handler h) {
        this.handler = h;
    }

    public void keyPressed(KeyEvent a) {
        int key = a.getKeyCode();

        for (int i = 0; i < handler.things.size(); i++) {
            Thing object = handler.things.get(i);

            if (object.getId() == ObjectID.Player) {
                // only runs if player is pressing down specified key
                if (key == KeyEvent.VK_UP) {
                    object.setYVel(-5);
                }
                if (key == KeyEvent.VK_LEFT) {
                    object.setXVel(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    object.setYVel(5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    object.setXVel(5);
                }
            }
        }
    }

    public void keyReleased(KeyEvent a) {
        int key = a.getKeyCode();

        for (int i = 0; i < handler.things.size(); i++) {
            Thing object = handler.things.get(i);

            if (object.getId() == ObjectID.Player) {
                // only runs if player is pressing down specified key
                if (key == KeyEvent.VK_UP) {
                    object.setYVel(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    object.setXVel(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    object.setYVel(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    object.setXVel(0);
                }
            }
        }
    }
}
