package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public abstract class Movable extends GameObjects {

	public abstract void draw(Graphics g, Point containerOrigin);
}