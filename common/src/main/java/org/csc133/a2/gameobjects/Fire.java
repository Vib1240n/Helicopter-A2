package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.util.Random;

public class Fire {

	Point Location;
	private static Random rand;
	private static Helicopter heli;
	private static int fire_size;

	public Fire() {
		// Empty Contructor
		rand = new Random();
		// heli = helicopter;
	}

	public Fire(int fire_size, Point p, Helicopter helicopter) {
		Location = p;
		Fire.fire_size = fire_size;
		heli = helicopter;

	}

	public Point location() {
		return Location;
	}

	public int size() {
		return fire_size;
	}

	public void grow_fire() {

		if (fire_size < 470) {
			fire_size += new Random().nextInt(5);
		}
	}

	public static void extinguishFire() {
		// fire_size -= Math.min(heli.water_tank() / 5, rand.nextInt(heli.water_tank() /
		// 3));
		if (fire_size - heli.water_tank() / 5 < 0) {
			fire_size = 0;
		} else {
			fire_size -= heli.water_tank() / 5;
		}
	}

	public void draw(Graphics g) {
		g.setColor(ColorUtil.MAGENTA);
		g.fillArc(Location.getX(), Location.getY(), fire_size, fire_size, 0,
				360);
		g.setFont(Game.font);
		g.drawString("" + fire_size, Location.getX() + fire_size + 10,
				Location.getY() + fire_size + 5);

		g.setColor(ColorUtil.YELLOW);
		g.drawString("x: " + Location.getX() + ", " + "y: " + Location.getY(),
				Location.getX(), Location.getY());

	}
}
