package lec7;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class Car implements Runnable {
    private static int CARS_COUNT;
    public static CountDownLatch cdl;
    private static ReentrantLock lock = new ReentrantLock();
    private static boolean winnerDeclared = false;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public Car(Race race, int speed, int outerCarsCount) {
        if (cdl == null) {
            cdl = new CountDownLatch(outerCarsCount + 1);
        }
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
            cdl.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        lock.lock();
        try {
            if (!winnerDeclared) {
                winnerDeclared = true;
                System.out.println(this.name + " победил в гонке!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
