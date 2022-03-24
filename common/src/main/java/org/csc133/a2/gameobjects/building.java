package org.csc133.a2.gameobjects;

import java.util.ArrayList;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class building extends Fixed {

    private ArrayList<building> buildings;
    private int building_height;
    private int building_width;
    public building(ArrayList<building> buildings){
        building_height = 100;
        building_width = 300;
        buildings = new ArrayList<building>();
        this.buildings = buildings;
    }
    // method setFireInBuilding(Fire f){ f.start() )
        public void draw(Graphics g, Point containerOrigin){
            
        }

}
