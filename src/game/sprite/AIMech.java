package game.sprite;

import engine.sprites.interfaces.ColisionInterface;
import engine.sprites.interfaces.ImageInterface;
import engine.sprites.tools.Position;

import java.awt.*;

@SuppressWarnings("unused")
public class AIMech extends MechBase implements ColisionInterface{

	private Font f1;
	private Dimension displayBounds;



	public AIMech() {
        super();
        angle = 0;
        //position = new Position(displayBounds.width / 3, displayBounds.height / 2);
        width = 20;
        height = 20;
		f1 = new Font("Times New Roman", Font.BOLD, (int) 12);

	}

	@Override
	public void update() {
        ltFwd = true;

        super.update();
	}

	@Override
	public void checkCollision(ColisionInterface obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public Rectangle intersects(Rectangle boundingBox) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(ImageInterface compareImage) {
		return this.getLayer() - ((ImageInterface) compareImage).getLayer();
	}

	@Override
	public int getLayer() {
		return 100;
	}
}
