package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;

import org.csc133.a2.GameWorld;
import org.csc133.a2.commands.Accelerate;

public class ControlCluster extends Container{
    private GameWorld gw;
    private Container container_left;
    private Container container_right;
    private Container container_center;
    private Button accelButton;
    private Button brake;
    private Button right;
    private Button left;
    private Button drink;
    private Button fight;
    private Button exit;


    public ControlCluster(GameWorld world){
        this.gw = world;
        this.setLayout(new BorderLayout());
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        accelButton = ButtonMaker("Accelerate", new Accelerate(gw));
        this.add(BorderLayout.CENTER, accelButton);
    }

    private Button ButtonMaker(String str, Command command){
        Button button = new Button(str);
        button.setCommand(command);
        return button;
    }
}
