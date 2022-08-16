package buyukadali.platformer;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class World implements Runnable {
	private Window window;
	private Thread thread;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	private Render render;
	
	public World() {
		// empty
	}
	
	private void init() {
		window = new Window("Platformer", 1200, 710);
		render = new Render(window);
	}
	
	private void update() {
		
	}
	
	private void draw() {
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		render.clear(0);
		render.drawFilledRect(0, 0, 110, 110, Render.RED | Render.GREEN);
		g.drawImage(render.getScreen(), 0, 0, window.getWidth(), window.getHeight(), null);
		bs.show();
		g.dispose();
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		if(!running)return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		init();
		while(running) {
			update();
			draw();
		}
		
		stop();
	}
}
