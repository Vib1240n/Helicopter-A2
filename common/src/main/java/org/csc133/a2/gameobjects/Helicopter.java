package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;
import org.csc133.a2.interfaces.Steerable;

import java.util.Random;


public class Helicopter extends Movable implements Steerable{
    static Point location;
    static River river;
    static com.codename1.ui.geom.Point river_location;
    static Point fire_location;
    // static Fire fire;
    // private static int fire_size;
    // private static int fire_radius;
    private static int heli_radius;
	private Helipad heli;
    private static float fuel;
    private static int speed;
    private static double angle;
    private static int endX;
    private static int endY;
    private static int startX;
    private static int startY;
    private static int water_tank;
    private static boolean isColliding;
    private static boolean isCollidingfire;
	private int boxSize;
    private static Random rand;
    private final int heli_size;

    public Helicopter() {
        water_tank = 0;
        isColliding = false;
        river = new River();
		heli = new Helipad();
        // fire = new Fire();
        // fire_location = fire.location();
        // fire_size = fire.size();
        // fire_radius = fire_size/2;
        isCollidingfire = false;
        river_location = river.getLocation();
        location = heli.getCenter();
		boxSize = heli.boxSize;
        heli_size = 35;
        heli_radius = heli_size / 2;
        angle = Math.toRadians(90);
        endX = (int) location.getX();
        endY = (int) (location.getY() + heli_radius * 3);
        startX = (int) location.getX();
        startY = (int) location.getY();
        rand = new Random();
        fuel = 12000;
    }

//    public static void movement(int input) {
//        /*
//         * movements
//         * //Separate all the methods
//         */
//        switch (input) {
//            case -92 /* back */:
//                if (speed > 0) {
//                    speed--;
//                }
//                break;
//            case -91 /* Forward */:
//                if (speed < 10) {
//                    speed++;
//                }
//                break;
//            case -93 /* Left */:
//                angle += Math.toRadians(15);
//                endX = (int) (endX + Math.cos(angle));
//                endY = (int) (endY - Math.sin(angle));
//                break;
//            case -94 /* Right */:
//                angle -= Math.toRadians(15);
//                endY = (int) (endX - Math.sin(angle));
//                endX = (int) (endY + Math.cos(angle));
//                break;
//            default:
//
//        }
//
//    }

	public void moveForward(){
		if (speed < 10) {
			speed++;
		}
	}

	public void brake(){
		if (speed > 0) {
			speed--;
		}
	}

	public void Left(){
		angle += Math.toRadians(15);
		endX = (int) (endX + Math.cos(angle));
		endY = (int) (endY - Math.sin(angle));
	}

	public void Right(){
		angle -= Math.toRadians(15);
		endY = (int) (endX - Math.sin(angle));
		endX = (int) (endY + Math.cos(angle));
	}

    public int water_tank() {
        return water_tank;
    }

    public static void updateForward() {
        location.setX((int) (location.getX() + Math.cos(angle) * speed));
        location.setY((int) (location.getY() - Math.sin(angle) * speed));
        startX = (int) location.getX();
        startY = (int) location.getY();
        endY = (int) (location.getY() - Math.sin(angle));
        endX = (int) (location.getX() + Math.cos(angle) + heli_radius * 3);
        fuel -= Math.max(startX, startY) * Math.tan(angle);
        setFuel(fuel);

    }

    public static void isCollison() {
        if (startX > river_location.getX() && startX < (river_location.getX()
                + river.get_river_width())) {
            isColliding = startY > river_location.getY() &&
                    startY < river_location.getY() + river.get_river_height();
        } else {
            isColliding = false;
        }
    }

    public static void isCollisionFire(Fire fire) {

        if (startX > fire.location().getX() && startX < (fire.location().getX()
                + fire.size())) {
            isCollidingfire = startY > fire.location().getY() &&
                    startY < fire.location().getY() + fire.size();
            if (isCollidingfire && fire.size() > 0) {
                fire.extinguishFire();
                water_tank = 0;
            }
        } // else{
          // isCollidingfire = false;
          // }
        isCollidingfire = true;
    }

    public void fillTank() {
        if (isColliding && water_tank < 1000) {
            water_tank += 100;
        }
    }

    public static int getFuel() {
        return (int) fuel;
    }

    protected static void setFuel(float fuel) {
        fuel = fuel;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        // TODO Auto-generated method stub
        g.setFont(Game.font);
        g.setColor(ColorUtil.YELLOW);
        g.fillArc(startX - heli_radius, startY - heli_radius, heli_size,
                heli_size, 0, 360);
        g.setColor(ColorUtil.YELLOW);
        g.drawLine(startX, startY, endX, endY);
        g.drawString("Speed: " + speed, startX + 15, startY + 15);

        g.setColor(ColorUtil.YELLOW);
        g.drawString("Water: " + water_tank,
				(int) (heli.getCenter().getX() - boxSize / 2),
				(int) ((heli.getCenter().getY() + 40) + boxSize / 2));
    }

	@Override
	public void steerLeft() {
		Steerable.super.steerLeft();
	}
}
