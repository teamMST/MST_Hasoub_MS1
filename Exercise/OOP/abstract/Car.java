package com.mst.oop.abstraction;

public class Car extends Vehicle {
    private int wheels;

    public Car(int model, int speed, int wheels) {
        super(model, speed);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public void go() {
        System.out.println("driving in a car!!!");
    }
}
