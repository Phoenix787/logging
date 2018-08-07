package multithreading_webinar;

public class Task {
    private final Object obj = new Object();

    private void waitTask(){ //здесь нет обозначения границ критической секции с помощью synchronized()
        try {
            obj.wait();
            System.out.println("Ok");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new Task().waitTask();
        new Task().action();
    }

    private void action() {
        try{
            synchronized (obj) {
                System.out.println("Action1");
                obj.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
