/**
 * @author Parth Chopra 2018
 */

package project.main;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public final int WIDTH = 640, HEIGHT = WIDTH * 3 / 4;
    private Thread thread;
    private boolean isRunning = false;

    private Random rand;
    private Handler handler;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyboardInput(handler)) ;

        new Frame(WIDTH, HEIGHT, "dodgeball", this);
        rand = new Random();

        handler.add(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ObjectID.Player));
    }

    public synchronized void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @source As cited by Zachary Berenger.
     */
    public void run() {
        long prevTime = System.nanoTime();
        double numTicks = 60.0, ns = 1000000000 / numTicks, delta = 0;
        long timer = System.currentTimeMillis();
        int numFrames = 0;
        while (isRunning) {
            long currTime = System.nanoTime();
            delta += (currTime - prevTime) / ns;
            prevTime = currTime;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (isRunning) {
                render();
            }
            numFrames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + numFrames);
                numFrames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy strat = this.getBufferStrategy();
        if (strat == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = strat.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        strat.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
