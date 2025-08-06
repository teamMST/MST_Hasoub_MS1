package com.mst.oop.abstraction;

public class Run {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car(12, 44, 4);
        vehicles[1] = new Airplane(13, 1000);
        for (var vehicle : vehicles) {
            vehicle.go();
        }
    }
}
