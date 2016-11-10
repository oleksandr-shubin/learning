package model.threads;

public class MessageLoop implements Runnable {
    private final int MESSAGES_ARRAY_SIZE = 3;
    private String[] messagesArray = new String[MESSAGES_ARRAY_SIZE];

    {
        messagesArray[0] = "first message";
        messagesArray[1] = "second message";
        messagesArray[2] = "third message";
    }

    @Override
    public void run() {
        for (String message : messagesArray) {
            try {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() +
                        ": " + message);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() +
                        ": Task is not completed");
                return;
            }
        }
    }
}
