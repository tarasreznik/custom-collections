package collections;

import collections.impl.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> intList = new MyArrayList<Integer>(new Object[]{1,2,3});
        intList.add(new Integer(1));
        intList.add(new Integer(2));
        intList.add(new Integer(3));
        intList.add(new Integer(4));
        intList.add(new Integer(5));
        intList.add(new Integer(6));
        intList.add(new Integer(7));
        intList.add(new Integer(8));
        intList.add(new Integer(9));
        intList.add(new Integer(10));
        intList.add(new Integer(11));
        intList.add(new Integer(12));
        System.out.println("MyArrayList");
        System.out.println("Size is: " + intList.size());

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        System.out.println("---------------------------------------");

        intList.remove(0);
        intList.remove(5);


        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        System.out.println("---------------------------------------\n");



        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(new Integer(5));
        linkedList.add(new Integer(6));
        linkedList.add(new Integer(7));
        linkedList.add(new Integer(8));
        linkedList.add(new Integer(9));
        linkedList.add(new Integer(10));
        System.out.println("MyLinkedList");
        System.out.println("Size is: " + linkedList.size());


        linkedList.remove(0);
        linkedList.remove(1);

        System.out.println("Size is: " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("---------------------------------------\n");




        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(new Integer(5));
        myQueue.add(new Integer(6));
        myQueue.add(new Integer(7));
        myQueue.add(new Integer(8));
        myQueue.add(new Integer(9));
        myQueue.add(new Integer(10));
        System.out.println("MyQueue");
        System.out.println("Size is: " + myQueue.size());


        for (int i = 0; i < 6; i++) {
            System.out.println(myQueue.poll());
        }
        System.out.println("Size is: " + myQueue.size());
        System.out.println("---------------------------------------\n");


        MyStack<Integer> stack = new MyStack<>();
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        stack.push(new Integer(4));
        stack.push(new Integer(5));
        stack.push(new Integer(6));
        stack.push(new Integer(7));
        System.out.println("MyStack");

        for (int i = 0; i < 7; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("---------------------------------------\n");

        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(3, "3");
        hashMap.put(4, "d");
        hashMap.put(5, "e");
        hashMap.put(5, "e");
        hashMap.put(4, "d");
        System.out.println("MyHashMap");

        hashMap.display();
        System.out.println(hashMap.size());
        hashMap.clear();
        hashMap.display();
        System.out.println(hashMap.size());


    }
}
