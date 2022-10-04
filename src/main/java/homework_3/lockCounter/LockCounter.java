package homework_3.lockCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private int value = 0;
    private int maxValue = 1000;
    private int threadLimit = 4;
    private Lock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    public void startCounter() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadLimit; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < maxValue / threadLimit; j++) {
                        lock.lock();
                        System.out.println(value);
                        ++value;
                        lock.unlock();
                    }
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
