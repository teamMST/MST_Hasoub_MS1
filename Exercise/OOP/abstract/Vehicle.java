package com.mst.oop.abstraction;

public abstract class Vehicle {
    private int model, speed;

    public Vehicle(int model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void go();
}
