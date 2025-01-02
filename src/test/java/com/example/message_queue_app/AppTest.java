package com.example.message_queue_app;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void testProducerConsumerSuccess() throws InterruptedException {
        MessageQueue<String> queue = new MessageQueue<>();
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        Producer producer = new Producer(queue, 5);
        Consumer consumer = new Consumer(queue, successCount, errorCount);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        Thread.sleep(1000); // Allow consumer to process messages

        assertEquals(5, successCount.get());
        assertEquals(0, errorCount.get());
    }

    @Test
    public void testConsumerErrorHandling() throws InterruptedException {
        MessageQueue<String> queue = new MessageQueue<>();
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        queue.enqueue("Message-1");
        queue.enqueue("Error-Message");

        Consumer consumer = new Consumer(queue, successCount, errorCount);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Thread.sleep(1000); // Allow consumer to process messages

        assertEquals(1, successCount.get());
        assertEquals(1, errorCount.get());
    }
}
