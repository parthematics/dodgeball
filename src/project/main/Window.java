package project.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {

    private static final long serialVersionUID = -2413443434825455921L;

    public Window(int width, int height, String name, Game g) {
		JFrame frame =  new JFrame(name);

		frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(g);
        frame.setVisible(true);
        g.start();
	}
}
