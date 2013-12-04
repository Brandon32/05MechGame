package game.sprite;

import engine.Input;
import engine.sprites.interfaces.ColisionInterface;
import engine.sprites.interfaces.ImageInterface;
import engine.sprites.interfaces.UIInterface;
import engine.tools.DebugInfo;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerMech extends MechBase implements ColisionInterface, UIInterface {

	private Font f1;
	private Dimension displayBounds;

	private int mouseX;
	private int mouseY;

	public PlayerMech() {
        super();

//		position.set(displayBounds.width / 2, displayBounds.height / 2);
		boundingBox.setLocation(position.getX(), position.getY());

	}

	@Override
	public void update() {
		super.update();

	}

	@Override
	public void draw(Graphics2D g) {

		g.rotate(-angle, position.getX(), position.getY());// mech
		g.setColor(Color.BLUE);
		g.fillRect(position.getX() - width / 2, position.getY() - height / 2,
				width, height);

		// top left
		if (leftLegSpeed > 0)
			g.setColor(new Color(Math.abs((int) (leftLegSpeed
					/ maxLegSpeed * 231)), 155, 155));
		else
			g.setColor(new Color(0, 155, 155));
		g.fillOval(position.getX() - width / 2, position.getY() - height / 2,
				10, 10);

		// botom left
		if (leftLegSpeed <= 0)
			g.setColor(new Color(Math.abs((int) (leftLegSpeed
					/ maxLegSpeed * 231)), 155, 155));
		else
			g.setColor(new Color(0, 155, 155));
		g.fillOval(position.getX() - width / 2, position.getY(), 10, 10);

		// top right
		if (rightLegSpeed > 0)
			g.setColor(new Color(Math.abs((int) (rightLegSpeed
					/ maxLegSpeed * 231)), 155, 155));
		else
			g.setColor(new Color(0, 155, 155));
		g.fillOval(position.getX(), position.getY() - height / 2, 10, 10);

		// botom right
		if (rightLegSpeed <= 0)
			g.setColor(new Color(Math.abs((int) (rightLegSpeed
					/ maxLegSpeed * 231)), 155, 155));
		else
			g.setColor(new Color(0, 155, 155));
		g.fillOval(position.getX(), position.getY(), 10, 10);

		g.rotate(angle, position.getX(), position.getY());// end mech

		// movement direction
		g.setColor(Color.BLACK);
		g.drawLine(position.getX(), position.getY(), position.getX()
				- (int) (xVel * 20 * scale), position.getY()
				- (int) (yVel * 20 * scale));

		// mouse
		g.drawLine(position.getX(), position.getY(), mouseX, mouseY);

		g.setColor(Color.red);
		g.drawLine(position.getX(), position.getY(),
				(int) (position.getX() - Math.sin(angle) * 10),
				(int) (position.getY() - Math.cos(angle) * 10)); // facing
																	// direction

		if (DebugInfo.isDebug()) {
			g.setFont(f1);
			g.setColor(Color.RED);
			g.drawRect(position.getX() + 99, position.getY() + 89, 200, 200);
			g.drawLine(position.getX() + width / 2, position.getY() + height
					/ 2, position.getX() + 99, position.getY() + 89);
			g.drawString(
					"Right Speed: " + String.format("%.3f", rightLegSpeed * 10),
					position.getX() + 100, position.getY() + 100);
			g.drawString(
					"Left Speed:  " + String.format("%.3f", leftLegSpeed * 10),
					position.getX() + 100, position.getY() + 110);
			g.drawString("Angle: " + (int) Math.toDegrees(angle) + " Degrees",
					position.getX() + 100, position.getY() + 120);
			g.drawString("Speed: " + Math.round(speed * 10),
					position.getX() + 100, position.getY() + 130);
			g.drawString("X Velocity: " + String.format("%.3f", xVel * 10),
					position.getX() + 100, position.getY() + 140);
			g.drawString("Y Velocity: " + String.format("%.3f", yVel * 10),
					position.getX() + 100, position.getY() + 150);
		}
	}

	@Override
	public void keyboardEvent() {

		ltFwd = false;
		rtFwd = false;
		ltBck = false;
		rtBck = false;

		// Forward
		if (Input.isActive(KeyEvent.VK_W)) {
			ltFwd = true;
			rtFwd = true;
		}
		// Backwards
		else if (Input.isActive(KeyEvent.VK_S)) {
			ltBck = true;
			rtBck = true;
		}

		if (Input.isActive(KeyEvent.VK_E)) // Forward right
			ltFwd = true;
		else if (Input.isActive(KeyEvent.VK_D)) // Reverse right
			ltBck = true;

		if (Input.isActive(KeyEvent.VK_Q)) // Forward left
			rtFwd = true;
		else if (Input.isActive(KeyEvent.VK_A)) // Reverse left
			rtBck = true;
	}

	@Override
	public void mouseEvent() {
		mouseX = Input.getX();
		mouseY = Input.getY();
	}

	@Override
	public void checkCollision(ColisionInterface obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle intersects(Rectangle boundingBox) {
		return (this.boundingBox.intersects(boundingBox) ? this.boundingBox
				.getBounds() : null);
	}

	@Override
	public int compareTo(ImageInterface compareImage) {
		return this.getLayer() - (compareImage).getLayer();
	}

	@Override
	public int getLayer() {
		return 100;
	}
}
