package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.*;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld extends Form {
	private final Random random = new Random();
	private int rand;
	// private int fire_size_center;
	// private int fire_size_left;
	// private int fire_size_right;
	// private ArrayList<Fire> fires;
	private ArrayList<GameObjects> objs;
	// making it private
	private Helicopter heli;
	private Point location_left;
	/**
	 * Building variables
	 */
	private ArrayList<building> buildings;
	private Point building_leftPoint;
	private Point building_rightPoint;
	private Point building_topPoint;
	private Point location_right;
	private Point location_center;
	private building b_top;
	private building b_left;
	private building b_right;

	/**
	 * Other variables
	 */
	private Helipad pad;
	private River river;
	private Fire fire_center;
	// private Fire fire_right;
	// private Fire fire_left;
	private Dimension size;

	public void init() {
		/*
		 * Initiliazing variables
		 */
		heli = new Helicopter(size);
		pad = new Helipad(size);
		river = new River();
		rand = random.nextInt(200);

		objs = new ArrayList<GameObjects>();
		// top_building();
		// right_building();
		// left_building();
		location_center = new Point((pad.getCenter().getX() + Game.Disp_H / 8) + rand,
				(pad.getCenter().getY() - Game.Disp_W / 3) + rand);

		int fire_size_center = random.nextInt(100) + 200;

		fire_center = new Fire(fire_size_center, location_center);

		objs.add(heli);
		objs.add(river);
		objs.add(pad);
		objs.add(fire_center);

		System.err.println("State: " + fire_center.getState());

	}

	public GameWorld() {
	}

	public ArrayList<building> buildingObjs() {
		buildings = new ArrayList<building>();
		// building_leftPoint = new Point(x, y)
		return buildings;
	}

	public ArrayList<GameObjects> getGameObjectCollection() {
		return objs;
	}

	public void top_building() {
		int building_height = 100;
		int building_width = 400;
		building_topPoint = new Point(size.getHeight() / 2,
				(int) (size.getWidth() * 1.5));
		b_top = new building(building_topPoint,
				building_height, building_width);

		buildings.add(b_top);
	}

	public void right_building() {
		int building_height = 250;
		int building_width = 100;
		building_topPoint = new Point(size.getHeight(), size.getWidth());
		b_right = new building(building_topPoint,
				building_height, building_width);

		buildings.add(b_right);
	}

	public void left_building() {
		int building_height = 200;
		int building_width = 75;
		building_topPoint = new Point(size.getHeight(), size.getWidth());
		b_left = new building(building_topPoint,
				building_height, building_width);

		buildings.add(b_left);
	}

	// public void building_draw(){
	// for(int i= 0; i< buildings.size(); i++){
	// buildings.get(i).draw(g, containerOrigin);
	// }
	// }

	public void quit() {
		Display.getInstance().exitApplication();
	}

	public void steerLeft() {
		heli.steerLeft();
	}

	public void steerRight() {
		heli.steerRight();
	}

	public void Accelerate() {
		heli.moveForward();
	}

	public void Brake() {
		heli.brake();
	}

	public void Drink() {
		heli.fillTank();
	}

	public void setDimension(Dimension size) {
		this.size = size;
	}

	public void updateTick(int timer) {
		heli.updateForward();
		heli.isCollison();
		// heli.isCollisionFire(fire_center);
		// heli.isCollisionFire(fire_left);
		// heli.isCollisionFire(fire_right);
		// if (timer % 20 == 0) {
		// for (int i = 0; i < fires.size(); i++) {
		// fires.get(i).grow_fire();
		//
		// }
		// }
	}
}
