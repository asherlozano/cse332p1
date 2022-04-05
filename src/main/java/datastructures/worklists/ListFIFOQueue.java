package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FIFOWorkList;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private class Node<E>{
        int data;
        Node<E> next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<E> front;
    private Node<E> rear;


    @Override
    public void add(E work) {
        Node<E> temp = new Node<E>(work);
        if (this.front == null){
            this.front = this.rear = temp;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    @Override
    public E peek() {
        throw new NotYetImplementedException();
    }

    @Override
    public E next() {
        if (this.front == null){
            throw new NullPointerException();
        }
        Node<E> temp = this.front;
        Node<E> nextNode = this.front.next;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
        return
    }

    @Override
    public int size() {
        int i = 0;
        while (this.front.next != null){
            i++;
        }
        return i;
    }

    @Override
    public void clear() {
        while (this.front.next != null){
            this.front = this.front.next;
        }
    }
}
