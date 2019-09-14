package com.example.learn.generic;


interface GenericInterfaceTest3<T> {

    T next();
}

/**
 * 未传入泛型实参时
 * @param <T>
 */
class GenericInterfaceClassTest3<T> implements GenericInterfaceTest3<T> {

    @Override
    public T next() {
        return null;
    }
}

/**
 * 传入泛型实参时：
 */
public class GenericTest3 implements GenericInterfaceTest3<String> {

    String[] array = new String[]{"A", "B", "C"};
    int count = 0;

    @Override
    public String next() {
        count ++;
        return array[count % 3];
    }

    public static void main(String[] args) {
        GenericTest3 genericTest3 = new GenericTest3();
        for (int i =0 ; i< 5; i++) {
            System.out.println(genericTest3.next());

        }
    }
}
