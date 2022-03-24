package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

public class River extends Fixed{
    Point Location;
    private final int river_width;
    private final int river_height;

    public River() {
		Location = new Point(0, Game.Disp_H - 1300);
		river_height = 300;
		river_width = Game.Disp_W - 10;
	}

    /**
     * Getter methods for correct collision checking for helicopter
     */
    public Point getLocation() {
        return Location;
    }

    public int get_river_width() {
        return river_width;
    }

    public int get_river_height() {
        return river_height;
    }
    /*
     * Draw method for river
     */
	@Override
	public void draw(Graphics g, Point containerOrigin) {
        g.setColor(ColorUtil.GREEN);
        g.drawString("X: " +containerOrigin.getX() + "Y: "+ containerOrigin.getY(), containerOrigin.getX(), containerOrigin.getY());
        g.setColor(ColorUtil.GREEN);

        g.drawString("X: " + Location.getX() + "Y: "+ Location.getY(), Location.getX(), Location.getY());

        g.drawString("X: " + (Location.getX() + river_width) + " Y: "+ (Location.getY() + river_height), Location.getX() + river_width - 200, Location.getY() + river_height);

		g.setColor(ColorUtil.BLUE);
        g.drawRect(Location.getX(), Location.getY(), river_width,
                river_height);
	}
}
