package com.example.learn.dubbo.spi;

/**
 * Created by pafer on 17-7-28.
 */
public interface Spi {

    public boolean isSupport(String name);

    public String sayHello();
}
