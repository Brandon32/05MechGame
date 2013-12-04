package engine.sprites.interfaces;


public interface UIInterface extends ImageInterface {
	/**
	 * Receive a keyboard event.
	 */
	public abstract void keyboardEvent();

	public abstract void mouseEvent();
}
