package lec7.multithread;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    Semaphore semaphore;
    public Tunnel (int permits) {
        semaphore = new Semaphore(permits);
        this .length = 80 ;
        this .description = "Тоннель " + length + " метров" ;
    }
    @Override
    public void go (Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
