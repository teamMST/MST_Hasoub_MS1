package com.mst.oop.interfaces;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Karam", 24);
        people[1] = new Person("Dauod", 19);
        people[2] = new Person("Israa", 18);

        System.out.println("Before Sorting:");
        for (var p : people) {
            System.out.println(p);
        }
        Arrays.sort(people);
        System.out.println("After Sorting:");
        for (var p : people) {
            System.out.println(p);
        }
    }
}
