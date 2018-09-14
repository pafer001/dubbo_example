package com.own.learn.jdk.enum1;

interface Start{
    void start();
}

interface End{
    void end();
}
public enum  EnumInterface implements Start, End{
    TEST1
    ;


    @Override
    public void start() {

    }

    @Override
    public void end() {

    }
}
