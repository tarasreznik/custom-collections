package collections.impl;

import java.util.Arrays;

public class MyArrayList<E> {
    private final int DEFAULT_SIZE = 5;

    private static int currentIndex = 0;

    private Object[] myArrayList = {};


    public MyArrayList(Object[] myArrayList) {
        this.myArrayList = myArrayList;
        currentIndex = myArrayList.length;
    }

    public MyArrayList(int size){
        this.myArrayList = new Object[size];

    }

    public MyArrayList() {
        this.myArrayList = new Object[DEFAULT_SIZE];
    }

    public void add(Object obj) {
        if (currentIndex >= myArrayList.length) {
            doubleSize();
        }
        myArrayList[currentIndex] =  obj;
        currentIndex++;

    }

    public E get(int index) {
        if (index >= myArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        return (E) myArrayList[index];
    }

    public int size() {
        return currentIndex;
    }

    public void clear() {
        myArrayList = null;
        currentIndex = 0;
    }

    public void remove(int index) {
        Object[] tempArr =  new Object[myArrayList.length - 1];
        for (int i = 0, k = 0; i < myArrayList.length; i++) {
            if (i == index) {
                continue;
            }
            tempArr[k++] = myArrayList[i];
        }
        myArrayList = tempArr;
        currentIndex--;
    }

    private void doubleSize() {
        myArrayList = Arrays.copyOf(myArrayList, myArrayList.length * 2);
    }
}


