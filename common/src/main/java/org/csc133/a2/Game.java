package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.commands.*;
import org.csc133.a2.gameobjects.Fire;
import org.csc133.a2.views.ControlCluster;
import org.csc133.a2.views.GlassCockpit;
import org.csc133.a2.views.Mapview;

import static com.codename1.ui.CN.SIZE_SMALL;

public class Game extends Form implements Runnable{
    public final static int Disp_H = Display.getInstance().getDisplayHeight();
    public final static int Disp_W = Display.getInstance().getDisplayWidth();
    public static Font font = Font.createSystemFont(Font.FACE_SYSTEM,
            Font.STYLE_PLAIN, SIZE_SMALL);
    private final GameWorld world;
	Mapview mapview;
	ControlCluster clusterView;
	GlassCockpit cockpitView;
    UITimer timer;
    private int tick;

    public Game() {
        world = new GameWorld();
		mapview = new Mapview(world);
        tick = 0;
        timer = new UITimer(this);
		setTitle("Hornets");
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, mapview);
        timer.schedule(100, true, this);
        addKeyListener('Q', (evt) -> new exit(world));
        addKeyListener(-93, (evt) -> new TurnLeftCommand(world));
        addKeyListener(-94, (evt) -> new TurnRightCommand(world));
        addKeyListener(-91, (evt) -> new Accelerate(world));
        addKeyListener(-92, (evt) -> new Brake(world));
        addKeyListener('d', (evt) -> new Drink(world));
        //addKeyListener('f', (evt) -> Fire.extinguishFire());

    }

    public static int getMin_disp() {
        return Math.min(Disp_H, Disp_W);
    }

    public static int getMax_disp() {
        return Math.max(Disp_H, Disp_W);
    }

    public void paint(Graphics g) {
        super.paint(g);
		//world.draw(g);
    }

    @Override
    public void run() {
        int return_tick = Tick();
        world.updateTick(return_tick);
        repaint();
    }

    public int Tick() {
        tick++;
        return tick;
    }
}
