package com.example.learn.jdk.thread;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author wangzhenya
 */
public class AtomicIntegerFieldUpdaterTest {
    static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {

        User user = new User("conan", 15);
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));

        System.out.println(atomicIntegerFieldUpdater.get(user));
    }

    static class User {
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

}



