package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.gameobjects.*;
import org.csc133.a2.views.GlassCockpit;

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
	private GlassCockpit gc;
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
		gc = new GlassCockpit(this);
		System.err.println(size);
		pad = new Helipad(size);
		river = new River(size);
		rand = random.nextInt(200);
		heli = new Helicopter(size);
		objs = new ArrayList<>();
		buildings = new ArrayList<>();


		top_building();
		right_building();
		left_building();
//		location_center =
//				new Point((pad.getCenter().getX() + Game.Disp_H / 8) + rand,
//				(pad.getCenter().getY() - Game.Disp_W / 3) + rand);

		int fire_size_center = random.nextInt(100) + 200;

		fire_center = new Fire(fire_size_center, location_center);

		objs.add(pad);
		objs.add(river);
		objs.add(heli);
		objs.add(fire_center);

		System.err.println("State: " + fire_center.getState());

	}

	public GameWorld() {
		size = new Dimension();
		init();
	}

	public ArrayList<GameObjects> getGameObjectCollection() {
		return objs;
	}


	public void top_building() {
	/**
	 * Building Dimensions
	 */
	int building_height = 150;
	int building_width = (int)(size.getWidth() * 0.75);
	int building_value = 900;
	// Building Locations
	building_topPoint = new Point(size.getHeight() / 4,
	(int) (size.getWidth()/18));

	System.err.println("building top location x: "+ size.getHeight() / 4);
	System.err.println("building top location y: "+ (int) (size.getWidth()/18));
	//initializing building
	b_top = new building(building_topPoint,
	building_height, building_width, building_value);

	objs.add(b_top);
	}

	public void right_building() {
	/**
	 * Building Dimensions
	 */
	int building_height = size.getHeight()/2;
	int building_width = size.getWidth() /8;
	int building_value = 300;
	// Building Locations
	building_rightPoint = new Point(size.getHeight() + size.getHeight()/6,
			size.getWidth() /4);

		System.err.println("building right location x: "+ size.getHeight() + size.getHeight()/6);
		System.err.println("building right location y: "+ size.getWidth() /3);
	// initializing building
	b_right = new building(building_rightPoint,
	building_height, building_width, building_value);

	objs.add(b_right);;
	}

	public void left_building() {
		/**
		 * Building Dimensions
		 */
		int building_height = size.getHeight() / 3;
		int building_width = size.getWidth() / 11;
		int building_value = 300;
	// Building Locations
	building_leftPoint = new Point((int)(size.getHeight() * 0.1),
			(int)(size.getWidth() / 3.4));

		System.err.println("building left location x: "+ (int)(size.getHeight() * 0.1));
		System.err.println("building left location y: "+ size.getWidth() /3);
	// initializing building
	b_left = new building(building_leftPoint,
	building_height, building_width, building_value);

	objs.add(b_left);
	}

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

	public String getSpeed(){
		return Integer.toString(heli.get_speed());
	}

	public String getFuel(){
		return Integer.toString(heli.getFuel());
	}

	public void updateTick(int timer) {
		gc.update();
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
