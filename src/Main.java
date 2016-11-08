import model.threads.MessageLoop;

public class Main {
    public static void main(String[] args) {
        new Thread(new MessageLoop()).start();
    }
}
