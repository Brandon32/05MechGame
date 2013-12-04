package engine.interfaces;

import java.awt.Graphics2D;

import engine.sprites.interfaces.ImageInterface;

/**
 * Sprite class
 * 
 * @author Brandon Marshall
 */
public interface LevelInterface {
	/**
	 * Update the sprite's state.
	 * 
	 */
	public abstract void update();

	/**
	 * Draw method
	 * 
	 * @param g
	 */

	public abstract void draw(Graphics2D g);

	/**
	 * Determine if the passed Sprite object collided with this object.
	 */
	public abstract void checkCollision();

	/**
	 * Receive a keyboard event.
	 */
	public abstract void keyboardEvent();

	/**
	 * Receive a mouse event.
	 */
	public abstract void mouseEvent();

	public abstract void clearLists();

	public abstract void addFirst(ImageInterface attachment);

	public abstract void remove(ImageInterface attachment);

	public abstract void addLast(ImageInterface attachment);

}
