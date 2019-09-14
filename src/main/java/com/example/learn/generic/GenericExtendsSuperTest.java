package com.example.learn.generic;

import java.util.ArrayList;
import java.util.List;

class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

class RedApple extends Apple {
}

public class GenericExtendsSuperTest<T> {

    public void genericExtends() {

        final List<? extends Fruit> fruits = new ArrayList<>();
        //error
        //fruits.add(new Apple());
        //fruits.add(new Fruit());
        //fruits.add(new Object());
        fruits.add(null);

        final Fruit fruit = fruits.get(0);
        final Apple apple = (Apple)fruits.get(0);
        fruits.contains(new Fruit());
    }



        public void genericSuper() {

            final List<? super Fruit> fruits = new ArrayList<>();
            fruits.add(new Apple());
            fruits.add(new Fruit());
            fruits.add(null);
            //error
            //final Fruit fruit = fruits.get(0);
            //final Apple apple = (Apple)fruits.get(0);
            //fruits.contains(new Fruit());
        }
}
