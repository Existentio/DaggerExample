package com.existentio.daggerexample.model;

import javax.inject.Inject;

/**
 * Created by Flor on 09.11.2017.
 */

public class Vehicle {
    private Engine engine;

    @Inject
    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public void increaseSpeed(int value) {
        engine.accelerate(value);
    }

    public void stop() {
        engine.brake();
    }

    public int getSpeed() {
        return engine.getRpm();
    }


}
