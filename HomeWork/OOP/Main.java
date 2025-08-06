package com.mst.oop.encapsulation;

public class Main {
    public static void main(String[] args) {
        // Create a Student object:
        Student s1 = new Student(43, "Rozaleen");
        System.out.println(s1);

        // Set details
        s1.setGrade(85);
        s1.setGrade(110);

        // Print Details:
        System.out.println("Student Name:" + s1.getName());
        System.out.println("Student ID:" + s1.getStudentId());
        System.out.println("Grade:" + s1.getGrade());
        System.out.println("Is Passing:" + s1.isPassing());

        // Can't do it, since the default C'Tor is deleted by Java Compiler
        // When we define a parametrized C'Tor
        // Student s2 = new Student();
    }
}
