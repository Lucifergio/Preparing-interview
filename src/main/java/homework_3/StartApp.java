package homework_3;

import homework_3.lockCounter.LockCounter;
import homework_3.pingPong.PingPongThread;

public class StartApp {
    public static void main(String[] args) {
        counterLockTest();
        pingPongTest();
    }

    public static void pingPongTest () {
        PingPongThread thread1 = new PingPongThread("ping");
        PingPongThread thread2 = new PingPongThread("pong");
        thread1.start();
        thread2.start();

        try {
            thread2.wait();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void counterLockTest () {
        LockCounter lockCounter = new LockCounter();
        lockCounter.startCounter();
        System.out.println(lockCounter.getValue());
    }
}
