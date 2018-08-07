package multithreading_webinar;

import static java.lang.Thread.sleep;

public class PingPong {

    private String last = "PONG";

    public static void main(String[] args) {

        PingPong main = new PingPong();

        new Thread(()-> main.action("ping")).start();

        new Thread(() -> main.action("PONG")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                  main.action("ball");
            }
        }).start();
    }

    public synchronized void action(String message) {
        while (true) {
            if (last.equals(message)) {
                wait(this);
            } else {
                System.out.println(message);
                last = message;
                sleep(500);
                notifyAll();
            }
        }
    }

    private void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
