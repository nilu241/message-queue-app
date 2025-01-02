package com.example.message_queue_app;

/**
 * A consumer that processes messages from the queue.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
    private final MessageQueue<String> queue;
    private final AtomicInteger successCount;
    private final AtomicInteger errorCount;

    /**
     * Constructs a consumer with the specified queue, success counter, and error counter.
     * @param queue the message queue
     * @param successCount the counter for successful message processing
     * @param errorCount the counter for errors during message processing
     */
    public Consumer(MessageQueue<String> queue, AtomicInteger successCount, AtomicInteger errorCount) {
        this.queue = queue;
        this.successCount = successCount;
        this.errorCount = errorCount;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = queue.dequeue();
                processMessage(message);
                successCount.incrementAndGet();
            } catch (Exception e) {
                errorCount.incrementAndGet();
                System.err.println("Error processing message: " + e.getMessage());
            }
        }
    }

    /**
     * Processes a message.
     * Simulates an error if the message contains "Error".
     * @param message the message to process
     * @throws Exception if an error occurs during processing
     */
    private void processMessage(String message) throws Exception {
        System.out.println("Consumed: " + message);
        if (message.contains("Error")) {
            throw new Exception("Simulated error for: " + message);
        }
    }
}
