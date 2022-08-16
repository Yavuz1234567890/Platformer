package buyukadali.platformer;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private String title;
	private int width, height;
	private JFrame frame;
	private Canvas canvas;
	
	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		Dimension dimension = new Dimension(width, height);
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(canvas);
		frame.pack();
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
