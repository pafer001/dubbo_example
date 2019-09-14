package com.example.learn.jdk.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangzhenya
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> userAtomicReference = new AtomicReference<>();


    public static void main(String[] args) {

        User user = new User("conan", 15);
        userAtomicReference.set(user);
        User updateUser = new User("conan1", 115);
        userAtomicReference.compareAndSet(user, updateUser);

        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getOld());

    }
}

class User {
    private String name;
    private int old;

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
