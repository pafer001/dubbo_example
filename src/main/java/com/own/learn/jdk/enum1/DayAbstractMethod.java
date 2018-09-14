package com.own.learn.jdk.enum1;

public enum  DayAbstractMethod {

    FOOD {
        @Override
        public void printName() {
            System.out.println(" name is " + name());
        }
    };

    public abstract void printName();


    public static void main(String[] args) {

        DayAbstractMethod.FOOD.printName();
    }
}
