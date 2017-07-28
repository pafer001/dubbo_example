package com.own.learn.dubbo.spi;

import java.util.ServiceLoader;

/**
 * Created by pafer on 17-7-28.
 */
public class SpiFactory {

    private static ServiceLoader<Spi> spiLoader =
            ServiceLoader.load(Spi.class);

    public static Spi getSpi(String name) {
        for (Spi spi : spiLoader) {
            if (spi.isSupport(name) ) {
                return spi;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Spi spia = getSpi("SPIA");
        System.out.println(spia);
    }

}
