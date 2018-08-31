package com.own.learn.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericMethod<T> {

    T value;

    public GenericMethod(T value) {
        this.value = value;
    }

    /**
     * 虽然在方法中使用了泛型，但是这并不是一个泛型方法。
     *  这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
     *  所以在这个方法中才可以继续使用 T 这个泛型。
     * @return
     */
    public T getValue() {
        return value;
    }

    public void showValue(T genericObj){
        System.out.println(value + " / " + genericObj);
    }

    public <T>  T getLastValue(List<T> list) {
        return (list.get(list.size() -1));
    }

    public <T>  T getRandomValue(List<GenericMethod<T>> list) {
        final Random random = new Random();


        final GenericMethod<T> tGenericMethod = list.get(random.nextInt(list.size()));
        return tGenericMethod.value;
    }



    public static void main(String[] args) {

        final GenericMethod<String> stringGenericMethod = new GenericMethod<String>("23");
        stringGenericMethod.showValue("5");

        final ArrayList<GenericMethod<String>> objects = new ArrayList<>();
        objects.add(stringGenericMethod);
        objects.add(new GenericMethod<>("2ggg3"));
        System.out.println(stringGenericMethod.getLastValue(objects).getValue());
        System.out.println(stringGenericMethod.getRandomValue(objects));

    }
}
