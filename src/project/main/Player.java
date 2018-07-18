package project.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends Thing {

    Random rand = new Random();

    public Player(int xPos, int yPos, ObjectID id) {
        super(xPos, yPos, id);
        xVel = rand.nextInt(5) + 1;
        yVel = rand.nextInt(5);
    }

    @Override
    public void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(xPos, yPos, 32, 32);
    }
}
