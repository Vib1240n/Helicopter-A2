package org.csc133.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import org.csc133.a2.GameWorld;

public class Fight extends Command implements ActionListener {
	private final GameWorld gw;
	
	public Fight(GameWorld gw){
		super("Fight");
		this.gw = gw;
	}

	public void actionPerformed(ActionEvent e){
		gw.Fight();
	}
}
