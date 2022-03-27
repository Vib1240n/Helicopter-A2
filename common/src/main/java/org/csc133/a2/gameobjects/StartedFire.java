package org.csc133.a2.gameobjects;

public class StartedFire extends State{
    private static StartedFire instance = new StartedFire();

    private StartedFire() {}

    public static StartedFire instance() {
        return instance;
    }

    // Business logic and state transition
    @Override
    public void updateState(Fire fire) {
        fire.setCurrentState(ExtinguishFire.instance());
    }
}
