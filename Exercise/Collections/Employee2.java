package com.mst.collections;

import java.util.HashSet;
import java.util.Objects;

public class Employee2 {
       private String name;

    public Employee2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee2 employee2 = (Employee2) o;
        return Objects.equals(name, employee2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee1 e1 = new Employee1("Reem");
        Employee1 e2 = new Employee1("Waseem");
        HashSet<Employee1> employee1Set = new HashSet<>();
        employee1Set.add(e2);
        employee1Set.add(e1);
        System.out.println(employee1Set.size());
        System.out.println(employee1Set);


        Employee2 e3 = new Employee2("Reem");
        Employee2 e4 = new Employee2("Waseem");
        HashSet<Employee2> employee2Set = new HashSet<>();
        employee2Set.add(e3);
        employee2Set.add(e4);
        employee2Set.add(new Employee2("Ameen"));
        System.out.println(employee2Set.size());
        System.out.println(employee2Set);
    }
}
