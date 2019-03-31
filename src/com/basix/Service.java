package com.basix;

import java.util.concurrent.atomic.AtomicInteger;

public class Service {

    private static class ServiceHolder {
        public static Service getInstance() {
            System.out.println("+++ instantiate service");
            return new Service();
        }
    }

    public static Service getInstance() {
        System.out.println("+++ get service");
        return ServiceHolder.getInstance();
    }

    private Service() {
        System.out.println("+++ service constructed");
    }

    public int
    getCounter() {
        return atom.addAndGet(1);
    }

    private AtomicInteger atom = new AtomicInteger(0);
}
