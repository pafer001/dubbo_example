package com.own.learn.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {


    public static void main(String[] args) {

        Dao lastDao =  null;
        while (true) {
            DaoProxy daoProxy = new DaoProxy();

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Dao.class);
            enhancer.setCallback(daoProxy);

            Dao dao = (Dao)enhancer.create();
            System.out.println(dao == lastDao);
            lastDao = dao;
//            dao.update();
//            dao.select();
        }


    }
}
