package project.main;

import java.awt.*;

public class Player extends Thing {

    public Player(int xPos, int yPos, ObjectID id) {
        super(xPos, yPos, id);
        xVel = 1;
        yVel = 1;
    }

    @Override
    public void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, 32, 32);
    }
}
