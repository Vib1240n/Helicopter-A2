package org.csc133.a2.gameobjects;

import java.util.ArrayList;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class building extends Fixed {
    private int building_height;
    private int building_width;
    private Point location;

    public building(Point location, int height, int width){
        this.building_height = height;
        this.building_width = width;
        this.location = location;
    }
    public void setFireInBuilding(Fire f){ 
         
    }

    public void draw(Graphics g, Point containerOrigin){
        g.setColor(ColorUtil.rgb(255, 0, 0));
        g.drawRect(location.getX(), location.getY(), building_width, building_height);
    }

}
