package project.main;

import java.awt.Graphics;

public abstract class Thing {

    protected int xPos, yPos, xVel, yVel;
    protected ObjectID id;

    public Thing(int x, int y, ObjectID id) {
        this.xPos = x;
        this.yPos = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setXPos(int x) {
        this.xPos = x;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setID(ObjectID id) {
        this.id = id;
    }

    public ObjectID getId() {
        return id;
    }

    public void setXVel(int xVel) {
        this.xVel = xVel;
    }

    public void setYVel(int yVel) {
        this.yVel = yVel;
    }

    public int getXVel() {
        return xVel;
    }

    public int getYVel() {
        return yVel;
    }
}
