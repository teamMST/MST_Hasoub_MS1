package com.mst.oop.inheritance;

public class Paint {
    public static void main(String[] args) {
        WLine l1 = new WLine(10, 2);
        WLine l2 = new WLine(30,3);
        System.out.println("Drawing Line1:");
        l1.draw();
        System.out.println("Drawing Line2:");
        l2.draw();
    }
}
