package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FixedSizeFIFOWorkList;

/**
 * See cse332/interfaces/worklists/FixedSizeFIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private int currentSize;
    private E[] circleQueue;
    private int maxSize;
    private int back;
    private int front;
    public CircularArrayFIFOQueue(int capacity) {
        this.maxSize = capacity;
        circleQueue = (E) new <E>[this.maxSize];
        this.currentSize = 0;
        this.front = this.back = -1;
    }

    @Override
    public void add(E work) {
        if (isFull()){
            throw new IllegalArgumentException();
        }
        back = (back+1) % circleQueue.length;
        circleQueue[back] = work;
        currentSize++;
        if (front == -1){
            front = back;
        }
    }

    @Override
    public E peek() {
        if (currentSize == 0){
            throw new NullPointerException();
        }
        return circleQueue[front];
    }

    @Override
    public E peek(int i) {
        return circleQueue[i];
    }

    @Override
    public E next() {
        if(currentSize == 0){
            throw new NullPointerException();
        }
        E delete = circleQueue[front];
        circleQueue[front] = null;
        front = (front + 1) % circleQueue.length;
        currentSize--;
        return delete;
    }

    @Override
    public void update(int i, E value) {
        throw new NotYetImplementedException();
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in project 2. Leave this method unchanged for project 1.
        if (this == obj) {
            return true;
        } else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        } else {
            // Uncomment the line below for p2 when you implement equals
            // FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            // Your code goes here

            throw new NotYetImplementedException();
        }
    }

    @Override
    public int hashCode() {
        // You will implement this method in project 2. Leave this method unchanged for project 1.
        throw new NotYetImplementedException();
    }
}
