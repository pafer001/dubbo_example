package com.own.learn.dubbo.spi.a;

import com.own.learn.dubbo.spi.Spi;

/**
 * Created by pafer on 17-7-28.
 */
public class SpiAImpl implements Spi {


    public boolean isSupport(String name) {
        return "SPIA".equalsIgnoreCase(name);
    }

    public String sayHello() {
        return "spia say hello";
    }
}
