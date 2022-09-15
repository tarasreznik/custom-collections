package collections.impl;

public class MyLinkedList<E> {
    private Node<E> head;
    private int size = 0;

    public void add(E value) {
        Node<E> newNode = new Node(value);

        if (this.head == null) {
            head = newNode;
            size++;
        } else {
            size++;
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void remove(int index) {
        if(index == 0){
            Node<E> node = head;
            head = head.getNextNode();
        }else{
            Node<E> node = head;
            for (int i = 0; i < index -1; i++) {
                node = node.getNextNode();
            }
            node.setNextNode(node.getNextNode().getNextNode());
        }
        size--;
    }

    public E get(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getData();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}


