package collections.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MyStack<E> {
    private final int DEFAULT_SIZE = 5;
    private static int currentIndex = 0;
    private Object[] myQueue = {};

    public MyStack(Object[] myArrayList) {
        this.myQueue = myArrayList;
        currentIndex = myArrayList.length;
    }

    public MyStack(int size) {
        this.myQueue = new Object[size];

    }

    public MyStack() {
        this.myQueue = new Object[DEFAULT_SIZE];
    }
    public void push(Object obj) {
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
        return (E) myQueue[currentIndex - 1];
    }

    public E pop() {
        //Collections.reverse(Arrays.asList(myQueue));
        Object returnedObject = myQueue[currentIndex -1];
        myQueue = Arrays.copyOfRange(myQueue, 0, myQueue.length);
        currentIndex--;
        return (E) returnedObject;
    }

    private void doubleSize() {
        myQueue = Arrays.copyOf(myQueue, myQueue.length * 2);
    }
}
