package com.example.message_queue_app;

/**
 * A thread-safe implementation of a message queue.
 * @param <T> the type of messages stored in the queue
 */
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue<T> {
    private final Queue<T> queue = new LinkedList<>();

    /**
     * Adds a message to the queue.
     * @param message the message to add
     */
    public synchronized void enqueue(T message) {
        queue.add(message);
        notifyAll(); // Notify consumers waiting for messages
    }

    /**
     * Removes and returns a message from the queue.
     * Blocks if the queue is empty until a message is available.
     * @return the next message in the queue
     * @throws InterruptedException if interrupted while waiting
     */
    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait for a message to be available
        }
        return queue.poll();
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
