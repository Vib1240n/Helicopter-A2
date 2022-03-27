package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;
import java.lang.Math;

public class Helipad extends Fixed {
	public Point centerLocation;
	private final int padSize;
	private final int radius;
	protected int boxSize;
	protected double fuel;
	Point location;
	private Dimension worldSize;

	/*
	 * Helipad constructor
	 */
	public Helipad(Dimension worldSize) {
		boxSize = 200;
		padSize = 150;
		radius = padSize / 2;
		// location = new Point((worldSize.getHeight() / 2) - 25,
		// 		(worldSize.getWidth()/ 2) + 500);
		location = new Point(worldSize.getWidth() / 2 - boxSize / 2,
				(int) (worldSize.getHeight() - (boxSize * 1.5)));
		centerLocation = new Point(location.getX() + boxSize / 2,
				location.getY() + boxSize / 2);
		fuel = 12000.0;
		this.worldSize = worldSize;
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
		g.drawRect(location.getX(), location.getY() + containerOrigin.getY(), 200, 200);

		System.err.println("co X: "+ containerOrigin.getX());
		System.err.println("co Y: "+ containerOrigin.getY());

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
