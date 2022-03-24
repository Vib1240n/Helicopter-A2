package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameWorld extends Form{
    private final Random random = new Random();
    private int rand;
    private int fire_size_center;
    private int fire_size_left;
    private int fire_size_right;
    private ArrayList<Fire> fires;
	private ArrayList<GameObjects> objs;
    Helicopter heli;
    Point location_left;
    Point location_right;
    Point location_center;
    Helipad pad;
    River river;
    Fire fire_center;
    Fire fire_right;
    Fire fire_left;
	private Dimension size;

	public void init(){
		/*
		 * Initiliazing variables
		 */
		heli = new Helicopter();
		pad = new Helipad();
		river = new River();
		rand = random.nextInt(200);
		fires = new ArrayList<Fire>();
		objs = new ArrayList<GameObjects>();
		/*
		 * Fire Locations
		 */
		location_left =
				new Point((pad.getCenter().getX() - Game.Disp_H / 2) + rand, (pad.getCenter().getY() - Game.Disp_W) + rand);
		location_right = new Point((pad.getCenter().getX() - Game.Disp_H / 2) + rand, (pad.getCenter().getY() - Game.Disp_W / 3) + rand); //
		// Showing up on screen
		location_center = new Point((pad.getCenter().getX() + Game.Disp_H / 8) + rand, (pad.getCenter().getY() - Game.Disp_W / 3) + rand);
		/*
		 * Fire Sizes
		 */
		fire_size_center = random.nextInt(100) + 200;
		fire_size_left = random.nextInt(100) + 150;
		fire_size_right = random.nextInt(50) + 100;
		/*
		 * Fires on the screen; class objects
		 */
		fire_center = new Fire(fire_size_center, location_center, heli);
		fire_left = new Fire(fire_size_left, location_left, heli);
		fire_right = new Fire(fire_size_right, location_right, heli);
		fires.add(fire_center);
		fires.add(fire_left);
		fires.add(fire_right);

		objs.add(heli);
		objs.add(river);
		objs.add(pad);

	}
    public GameWorld() {

	}
	public ArrayList<GameObjects> getGameObjectCollection(){
		return objs;
	}
    public void quit() {
        Display.getInstance().exitApplication();
    }
    public void steerLeft(){
		heli.steerLeft();
	}
	public void steerRight(){
		heli.steerRight();
	}
	public void Accelerate(){
		heli.moveForward();
	}
	public void Brake(){
		heli.brake();
	}
	public void Drink(){
		heli.fillTank();
	}

	public void setDimension(Dimension size){
		this.size = size;
	}
    public void updateTick(int timer) {
        heli.updateForward();
//        heli.isCollison();
//        heli.isCollisionFire(fire_center);
//        heli.isCollisionFire(fire_left);
//        heli.isCollisionFire(fire_right);
//        if (timer % 20 == 0) {
//            for (int i = 0; i < fires.size(); i++) {
//                fires.get(i).grow_fire();
//
//            }
//        }
    }
}
