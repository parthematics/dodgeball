package project.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<Thing> things = new LinkedList<Thing>();

    public void tick() {
        for (int i = 0; i < things.size(); i++) {
            Thing tempThing = things.get(i);
            tempThing.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < things.size(); i++) {
            Thing tempThing = things.get(i);
            tempThing.render(g);
        }
    }

    public void addThing(Thing thing) {
        this.things.add(thing);
    }

    public void removeThing(Thing thing) {
        this.things.remove(thing);
    }

}
