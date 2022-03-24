package org.csc133.a2.views;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObjects;

public class Mapview extends Container {

	private GameWorld gw;
	public Mapview(GameWorld gw){
		this.gw = gw;
	}

	@Override
	public void laidOut(){
		//set dimension = create new dimension = actual play area
	}

	@Override
	public void paint(Graphics g){
		//iterator arraylist and draw everything
		super.paint(g);
		for(GameObjects go: gw.getGameObjectCollection()){
			go.draw(g, new Point(this.getX(), this.getY()));
		}
	}

}
