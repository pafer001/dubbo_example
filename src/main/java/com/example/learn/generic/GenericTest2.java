package com.example.learn.generic;

public class GenericTest2<T> {

    T value;

    public GenericTest2(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }


    public static void main(String[] args) {

        GenericTest2<String> stringGenericTest2 = new GenericTest2<>("!");
        GenericTest2<Integer> stringGenericTest3 = new GenericTest2<>(2);

        System.out.println(stringGenericTest2.getValue());
        System.out.println(stringGenericTest3.getValue());


    }
}
