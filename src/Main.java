import model.threads.MessageLoop;

public class Main {
    public static void main(String[] args) {
        Thread auxThread = new Thread(new MessageLoop());
        String currentThreadName = Thread.currentThread().getName();

        System.out.println(currentThreadName + ": Start MessageLoop thread");
        auxThread.start();
        System.out.println(currentThreadName + ": Waiting until the second thread" +
                " finishes its execution");
        while (auxThread.isAlive()) {
            System.out.println(currentThreadName + ": I'm waiting");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // logging of exception
            }
        }
        System.out.println(currentThreadName + ": The end");
    }
}
