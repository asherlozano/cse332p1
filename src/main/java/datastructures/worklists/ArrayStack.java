package datastructures.worklists;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.LIFOWorkList;

/**
 * See cse332/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
    int size;
    int stack[];
    int top;

    public ArrayStack() {
        this.size = size;
        this.stack = new int[10];
        this.top = -1;
    }

    @Override
    public void add(E work) {
        if(top != 10){
            top++;
            stack[top] = work;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public E peek() {
        throw new NotYetImplementedException();
    }

    @Override
    public E next() {
        throw new NotYetImplementedException();
    }

    @Override
    public int size() {
        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }
}
