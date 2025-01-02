package com.example.message_queue_app;

/**
 * A producer that generates messages and adds them to the queue.
 */
public class Producer implements Runnable {
    private final MessageQueue<String> queue;
    private final int messageCount;

    /**
     * Constructs a producer with the specified queue and message count.
     * @param queue the message queue
     * @param messageCount the number of messages to produce
     */
    public Producer(MessageQueue<String> queue, int messageCount) {
        this.queue = queue;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= messageCount; i++) {
            String message = "Message-" + i;
            queue.enqueue(message);
            System.out.println("Produced: " + message);
        }
    }
}
