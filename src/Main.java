import model.computer.Computer;
import model.computer.Desktop;
import model.computer.Laptop;
import model.computer.Tablet;
import model.store.Cart;

public class Main {
        public static class MyRunner implements Runnable {

            @Override
            public void run() {
                System.out.println("Thread, which implements Runnable");
            }
        }

        public static class MyThread extends Thread {

            @Override
            public void run(){
                System.out.println("Thread, which extends Thread");
            }
        }

    public static void main(String[] args) {
        new Thread(new MyRunner()).start();
        new MyThread().start();
    }
}
