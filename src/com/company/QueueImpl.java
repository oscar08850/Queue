package com.company;

public class QueueImpl<E> implements Queue<E> {

    private E[] vector;
    private int max;
    private int lib;

    public QueueImpl(int max){
        this.vector = (E[]) new Object[max];
        this.max = max;
        this.lib = 0;
    }

    public E[] pop() throws EmptyQueueException {
        if (this.lib != 0) {
            vector[0] = null;
            for (int i = 0; i < this.lib - 1; i++)
                vector[i] = vector[i + 1];
            vector[this.lib - 1] = null;
            this.lib--;
            return vector;
        } else
            throw new EmptyQueueException();
    }

    public void push(E e) throws FullQueueException {
        if (this.lib < this.max) {
            vector[this.lib] = e;
            this.lib++;
        } else
            throw new FullQueueException();
    }

    public int size() {
        return vector.length;
    }
}
