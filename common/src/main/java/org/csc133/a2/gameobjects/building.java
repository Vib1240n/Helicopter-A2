package org.csc133.a2.gameobjects;

import java.util.ArrayList;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class building extends Fixed {
    private int building_height;
    private int building_width;
	private int building_value;
    private Point location;

    public building(Point location, int height, int width, int value){
        this.building_height = height;
        this.building_width = width;
		this.building_value = value;
        this.location = location;
    }
    public void setFireInBuilding(Fire f){ 
		f.Startfire(location);
    }

    @Override
    public void draw(Graphics g, Point containerOrigin){
		final Point loc =
				new Point (location.getX() + containerOrigin.getX(),
						location.getY() + containerOrigin.getY());

		g.setColor(ColorUtil.rgb(255,0,0));
		g.drawString("X: " + location.getX(),  loc.getX() ,
				loc.getY());
		g.drawString("Y: " + loc.getY(), loc.getX() + 150,
				loc.getY());
		g.setColor(ColorUtil.rgb(255,0,0));
		g.drawString("V: " + this.building_value,
				loc.getX() + building_width,
				loc.getY() + (int)(building_height / 1.2));

        g.setColor(ColorUtil.rgb(255, 0, 0));
        g.drawRect(loc.getX(), loc.getY(), building_width, building_height);
    }

}
