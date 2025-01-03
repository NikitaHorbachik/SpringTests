package lec7;

import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4 ;

    public static void main (String[] args)  {


        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );
        Race race = new Race( new Road( 60 ), new Tunnel(CARS_COUNT / 2), new Road( 40 ));
        Car[] cars = new Car[CARS_COUNT];
        for ( int i = 0 ; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + ( int ) (Math.random() * 10 ), CARS_COUNT);
        }
        Thread[] carThreads = new Thread[4];
        for ( int i = 0 ; i < cars.length; i++) {
            carThreads[i] = new Thread(cars[i]);
            carThreads[i].start();
        }
        Car.cdl.countDown();
        try {
            Car.cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );

        for ( int i = 0 ; i < cars.length; i++) {
            try {
                carThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
    }
}

