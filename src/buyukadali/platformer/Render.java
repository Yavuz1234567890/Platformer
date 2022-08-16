package buyukadali.platformer;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Render {
	public static int RED = 0xffff0000, GREEN = 0xff00ff00, BLUE = 0xff0000ff;
	
	private int[] pixels;
	private BufferedImage screen;
	private int width, height;
	
	public Render(Window window) {
		width = window.getWidth();
		height = window.getHeight();
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)screen.getRaster().getDataBuffer()).getData();
	}
	
	public void clear(int color) {
		for(int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}
	
	public void drawFilledRect(int x, int y, int w, int h, int color) {
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				setPixel(x + i, y + j, color);
			}
		}
	}
	
	public void setPixel(int x, int y, int color) {
		if(x < 0 || x > width || y < 0 || y > height)return;
		pixels[x + y * width] = color;
	}
	
	public int getPixel(int x, int y) {
		return pixels[x + y * width];
	}
	
	public BufferedImage getScreen() {
		return screen;
	}
}
