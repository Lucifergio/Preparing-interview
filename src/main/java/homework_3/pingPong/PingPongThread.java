package homework_3.pingPong;

public class PingPongThread extends Thread {

    private static final Object lock = new Object();

    private String toPrintOut;

    public PingPongThread(String s) {
        this.toPrintOut = s;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                    System.out.println(this.toPrintOut);
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
            }
        }
    }
}