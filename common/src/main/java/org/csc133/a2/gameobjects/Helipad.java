package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

public class Helipad extends Fixed {
	public Point centerLocation;
	private int padSize;
	private int radius;
	protected int boxSize;
	protected double fuel;
	Point location;

	/*
	 * Helipad constructor
	 */
	public Helipad() {
		boxSize = 200;
		padSize = 150;
		radius = padSize / 2;
		location = new Point((Game.Disp_W / 2) - 25,
				(Game.getMin_disp() / 2) + 500);
		centerLocation = new Point(location.getX() + boxSize / 2,
				location.getY() + boxSize / 2);
		fuel = 12000.0;
	}

	public Point getCenter() {
		return centerLocation;
	}

	public void setFuel(float fuel) {
		fuel = fuel;
	}

	@Override
	public void draw(Graphics g, Point containerOrigin) {
		g.setColor(ColorUtil.GRAY);
		g.drawRect((int) containerOrigin.getX(), (int) containerOrigin.getY(), 200, 200);

		/*
		 * Fuel label drawing
		 */
		g.setColor(ColorUtil.YELLOW);
		g.drawString("Fuel: " + (int) fuel, (centerLocation.getX() - boxSize / 2),
				((centerLocation.getY() + 5) + boxSize / 2));
		/*
		 * Helipad inner circle design
		 */
		g.setColor(ColorUtil.GRAY);
		g.drawArc((centerLocation.getX() - radius), (centerLocation.getY() - radius), padSize, padSize, 0,
				360);
	}
}
