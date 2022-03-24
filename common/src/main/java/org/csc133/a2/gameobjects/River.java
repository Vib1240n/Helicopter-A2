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
		river_width = Game.Disp_W;
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
		g.setColor(ColorUtil.BLUE);
        g.drawRect(containerOrigin.getX(), containerOrigin.getY(), river_width,
                river_height);
	}
}
