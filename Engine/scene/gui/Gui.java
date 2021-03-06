package scene.gui;

import org.joml.Vector3f;

import audio.Source;
import scene.gui.text.Font;

public class Gui {
	
	public static final int DEPTH_SEQUENTIAL = 0;
	
	protected Source source = new Source();
	
	public void update() {}
	
	public void drawImage(Image image) {
		GuiControl.drawImage(image);
	}
	
	public Image drawImage(String texture, int x, int y) {
		return GuiControl.drawImage(texture, x, y);
	}
	
	public Image drawImage(String texture, int x, int y, int w, int h) {
		return GuiControl.drawImage(texture, x, y, w, h);
	}
	
	public Image drawImage(String texture, int x, int y, int w, int h, Vector3f color) {
		return GuiControl.drawImage(texture, x, y, w, h, color);
	}
	
	public Text drawString(Text text) {
		return GuiControl.drawText(text);
	}

	public Text drawString(String text, int x, int y) {
		return GuiControl.drawText(text, x, y);
	}
	
	public Text drawString(String text, int x, int y, boolean centered) {
		return GuiControl.drawText(text, x, y, centered);
	}
	
	public Text drawString(String text, int x, int y, float fontSize, boolean centered) {
		return GuiControl.drawText(text, x, y, fontSize, centered);
	}
	
	public Text drawString(String text, int x, int y, float fontSize, int lineWidth, boolean centered) {
		return GuiControl.drawText(text, x, y, fontSize, lineWidth, centered);
	}
	
	public Text drawString(Font font, String text, int x, int y, float fontSize, int lineWidth, boolean centered) {
		return GuiControl.drawText(font, text, x, y, fontSize, lineWidth, centered);
	}
	
	public void cleanUp() {
		GuiControl.clear();
		source.delete();
	}

	public void setOpacity(float f) {
		GuiControl.setOpacity(f);
	}

	public Source getSource() {
		return source;
	}

	public void drawLoadingScreen() {
		GuiControl.drawLoadingScreen();
	}
}
