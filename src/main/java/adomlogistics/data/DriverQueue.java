package adomlogistics.data;

import adomlogistics.model.Driver;

public class DriverQueue {
    private Driver[] queue;
    private int front, rear, size;
    public DriverQueue(int capacity) {
        queue = new Driver[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == queue.length; }
    public void enqueue(Driver d) {
        if (isFull()) return;
        rear = (rear + 1) % queue.length;
        queue[rear] = d;
        size++;
    }
    public Driver dequeue() {
        if (isEmpty()) return null;
        Driver d = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return d;
    }
    public Driver peek() {
        if (isEmpty()) return null;
        return queue[front];
    }
} 