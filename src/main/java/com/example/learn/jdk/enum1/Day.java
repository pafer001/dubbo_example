package com.example.learn.jdk.enum1;



public enum Day {
    MONDAY("monday"), TUESDAY("TUESDAY"), WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"), FRIDAY("FRIDAY"), SATURDAY("SATURDAY"), SUNDAY("SUNDAY");

    private String name;

    Day(String name) {
        this.name = name;
    }
}
