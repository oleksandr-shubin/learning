import com.sun.org.apache.xpath.internal.SourceTree;
import model.threads.MessageLoop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        try (Scanner scanner = new Scanner(System.in)) {
            Thread auxThread = new Thread(new MessageLoop());
            String auxThreadName = auxThread.getName();

            System.out.println("Enter time to wait (in milliseconds) " +
                    "until another threads finishes its execution");
            long timeToWait = scanner.nextLong();

            System.out.println(currentThreadName +
                    ": Starting MessageLoop thread");
            auxThread.start();
            System.out.println(currentThreadName +
                    ": Waiting until the second thread" +
                    " finishes its execution");
            try {
                auxThread.join(timeToWait);
                if (auxThread.isAlive()) {
                    System.out.println(currentThreadName + ": Won't wait anymore");
                    auxThread.interrupt();
                }
            } catch (InterruptedException e) {
                //logging of exception in main thread
            }
            System.out.println(currentThreadName + ": The end");
        }
    }
}
