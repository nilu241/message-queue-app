package com.example.message_queue_app;

/**
 * Main application to simulate producer-consumer scenario with logging.
 */
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        MessageQueue<String> queue = new MessageQueue<>();
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        Producer producer = new Producer(queue, 10);
        Consumer consumer = new Consumer(queue, successCount, errorCount);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            Thread.sleep(2000); // Allow consumer to process messages
            System.out.println("Total Messages Processed: " + successCount.get());
            System.out.println("Total Errors Encountered: " + errorCount.get());
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
