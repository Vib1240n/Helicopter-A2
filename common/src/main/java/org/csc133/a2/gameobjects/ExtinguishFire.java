package org.csc133.a2.gameobjects;

public class ExtinguishFire extends State{
    private static ExtinguishFire instance = new ExtinguishFire();

    private ExtinguishFire() {}

    public static ExtinguishFire instance() {
        return instance;
    }

    // Business logic and state transition
    @Override
    public void updateState(Fire fire) {

    }
}
