package cse332.interfaces.worklists;

/**
 * A subclass of WorkList that stores its elements in FIFO order. All subclasses
 * of this class implicitly agree to the contract to be a FIFO queue. That is,
 * addWork() must add to the "end" and next() must remove from the "beginning".
 *
 * @param <E> the type of elements in the worklist
 * @author Adam Blank
 */
public abstract class FIFOWorkList<E> extends WorkList<Void> {
    private class Node{
        int data;
        Node next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;
    public void Queue(){
        this.front = this.rear = null;
    }
    public void enqueue(int data){
        Node temp = new Node(data);
        if (this.front == null){
            this.front = this.rear = temp;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    public void dequeue(){
        if (this.front == null){
            return;
        }
        Node temp = this.front;
        this.front = this.front.next;
        if(this.front == null){
            this.rear = null;
        }
    }
}
