package game.levels;

import engine.event.GameEvent;
import engine.event.GameEvent.GameEventType;
import engine.event.GameEventDispatcher;
import engine.sprite.Image;
import game.Mech;

import java.awt.Graphics2D;

public class Level01 implements Image {
	private Mech myMech;

	public Level01() {
		myMech = new Mech();
		GameEventDispatcher.dispatchEvent(new GameEvent(this,GameEventType.AddFirst, myMech));
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}
}
