package com.mst.collections;

import java.util.Objects;

public class Employee1 {
    private String name;

    public Employee1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 123;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                '}';
    }
}
