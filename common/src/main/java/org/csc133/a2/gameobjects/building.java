package org.csc133.a2.gameobjects;

import java.util.ArrayList;
import java.util.Random;

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
        if(building_width != 0 && building_height != 0){
            Point new_location = new Point( new Random().nextInt(building_width) +location.getX() - 50, new Random().nextInt(building_height) + location.getY() - 50);
            f.Startfire(new_location);
        }
    }

    @Override
    public void draw(Graphics g, Point containerOrigin){
		// loc =
		// 		new Point (location.getX() + containerOrigin.getX(),
		// 				location.getY() + containerOrigin.getY());

//		g.setColor(ColorUtil.rgb(255,0,0));
//		g.drawString("X: " + location.getX(),  loc.getX() ,
//				loc.getY());
//		g.drawString("Y: " + loc.getY(), loc.getX() + 150,
//				loc.getY());
		g.setColor(ColorUtil.rgb(255,0,0));
		g.drawString("V: " + this.building_value,
				location.getX() + building_width,
				location.getY() + (int)(building_height / 1.2));

        g.setColor(ColorUtil.rgb(255, 0, 0));
        g.drawRect(location.getX() + containerOrigin.getX(), location.getY() 
                + containerOrigin.getY(), building_width, building_height);
    }

}
