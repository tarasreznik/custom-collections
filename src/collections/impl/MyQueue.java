package collections.impl;

import java.util.Arrays;

public class MyQueue<E> {
    private final int DEFAULT_SIZE = 5;
    private static int currentIndex = 0;
    private Object[] myQueue = {};

    public MyQueue(Object[] myArrayList) {
        this.myQueue = myArrayList;
        currentIndex = myArrayList.length;
    }

    public MyQueue(int size) {
        this.myQueue = new Object[size];

    }

    public MyQueue() {
        this.myQueue = new Object[DEFAULT_SIZE];
    }

    public void add(Object obj) {
        if (currentIndex >= myQueue.length) {
            doubleSize();
        }
        myQueue[currentIndex] = obj;
        currentIndex++;
    }

    public void remove(int index) {
        Object[] tempArr = new Object[myQueue.length - 1];
        for (int i = 0, k = 0; i < myQueue.length; i++) {
            if (i == index) {
                continue;
            }
            tempArr[k++] = myQueue[i];
        }
        myQueue = tempArr;
        currentIndex--;
    }

    public void clear() {
        myQueue = null;
        currentIndex = 0;
    }

    public int size() {
        return currentIndex;
    }

    public E peek() {
        return (E) myQueue[0];
    }

    public E poll() {
        Object returnedObject = myQueue[0];
        myQueue = Arrays.copyOfRange(myQueue, 1, myQueue.length);
        currentIndex--;
        return (E) returnedObject;
    }

    private void doubleSize() {
        myQueue = Arrays.copyOf(myQueue, myQueue.length * 2);
    }
}
