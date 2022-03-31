package org.csc133.a2.gameobjects;

import java.util.ArrayList;
import java.util.Iterator;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

//Used for Fire class
//
public abstract class GameObjectCollection<T> extends GameObjects{

    ArrayList<T> GameObjs;

    public GameObjectCollection(){

        GameObjs = new ArrayList<>();
    }

    public void add(T gameObjects){
        GameObjs.add(gameObjects);
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
