package com.existentio.daggerexample.model;

/**
 * Created by Flor on 09.11.2017.
 */

public class Engine {

    private int rpm;

    public Engine() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value) {
        rpm += value;
    }

    public void brake() {
        rpm = 0;
    }

}
