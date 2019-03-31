package com.basix;

import com.ships.Ship;

public class Main {
    static final int THREADS = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting main");

        //<editor-fold desc="+++ (1) Playing with Singleton and Threads">
        Service service = Service.getInstance();

        Runnable task = () -> {

            Double rand = Math.random();

            for (int i=1; i<1000; ++i) {
                Integer c = service.getCounter();
                System.out.println("+++ counter:" + c.toString());

                long ms = (long) (rand * 1000);

                try {
                    String tname = Thread.currentThread().getName();
                    System.out.printf("--- Trying to sleep for %d ms [%s]\n", ms, tname);
                    Thread.currentThread().sleep(ms);
                }
                catch (InterruptedException e) {
                    return;
                }

                rand = Math.random();
            }

        };

        Thread threads[] = new Thread[THREADS];
        for (int t=0; t<THREADS; ++t) {
            threads[t] = new Thread(task);
            threads[t].start();
        }

        for (int t=0; t<THREADS; ++t) {
            threads[t].join();
        }
        //</editor-fold>

        //<editor-fold desc="+++ (2) Play with Ships">
        Board board = new Board(10);

        Ship ship_1 = new Ship("3D", "6D");
        board.addShip(ship_1);

        Ship ship_2 = new Ship("3F", "6I");
        board.addShip(ship_2);

        board.hit("6G");

        board.hit("3D");
        board.hit("4D");
        board.hit("5D");
        board.hit("6D");

        board.showHits();
        //</editor-fold>

        System.out.println("Ending main");
    }
}
