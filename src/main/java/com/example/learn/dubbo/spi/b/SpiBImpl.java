package com.example.learn.dubbo.spi.b;

import com.example.learn.dubbo.spi.Spi;

/**
 * Created by pafer on 17-7-28.
 */
public class SpiBImpl implements Spi {
    public boolean isSupport(String name) {
        return "SPIB".equalsIgnoreCase(name);
    }

    public String sayHello() {
        return "spiB say hello";
    }
}
