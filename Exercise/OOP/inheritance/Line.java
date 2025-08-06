package com.mst.oop.inheritance;

public class Line {
    private int length;

    public Line(int length) {
        this.length = length;
    }

    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print('*');
        }
    }

}
