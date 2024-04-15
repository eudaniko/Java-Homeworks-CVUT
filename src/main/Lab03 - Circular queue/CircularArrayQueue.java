package cz.cvut.fel.pjv;

public class CircularArrayQueue implements Queue {
    private int currCapacity = 0;
    private final int DEFAULT_QUEUE_CAPACITY = 5;
    private final int maxCapacity;

    private final String[] arrayQueue;
    private int writeIndex = 0;
    private int readIndex = 0;

    public CircularArrayQueue() {
        maxCapacity = DEFAULT_QUEUE_CAPACITY;
        arrayQueue = new String[maxCapacity];
    }

    public CircularArrayQueue(int capacity) {
        maxCapacity = capacity;
        arrayQueue = new String[maxCapacity];
    }

    @Override
    public int size() {
        return currCapacity;
    }

    @Override
    public boolean isEmpty() {
        return currCapacity == 0;
    }

    @Override
    public boolean isFull() {
        return currCapacity == maxCapacity;
    }

    @Override
    public boolean enqueue(String item) {
        if (isFull() || item == null) return false;
        arrayQueue[writeIndex] = item;
        writeIndex = (writeIndex + 1) % maxCapacity;
        currCapacity++;
        return true;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) return null;
        String temp = arrayQueue[readIndex];
        arrayQueue[readIndex] = null;
        readIndex = (readIndex + 1) % maxCapacity;
        currCapacity--;
        return temp;
    }

    @Override
    public void printAllElements() {
        for (int i = 0; i < currCapacity; i++) {
            int index = (readIndex + i) % maxCapacity;
            System.out.println(arrayQueue[index]);
        }
    }
}
