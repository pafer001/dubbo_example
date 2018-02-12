package com.own.learn.jvm;

import java.util.HashMap;

public class MemoryLeakDemo {

    static class Key {

        private Integer id;

        public Key(Integer id) {
            this.id = id;
        }


        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }


    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        while (true) {

            for (int i=0; i< 1000; i++) {
                if (!map.containsKey(new Key(i))) {
                    System.out.println(map.size());
                    map.put(new Key(i), "Number : " + i);
                }
            }
        }
    }
}
