package dataStructures.singlyLinkedList;

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Integer> {

    private Node head;

    public void add(Integer data) {
        Node newNode = new Node(data);
        newNode.setData(data);

        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
    }

    public void add(Integer index, Integer data) {
        Node newNode = new Node(data);
        newNode.setData(data);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node currentNode = head;
            Node previousNode = null;
            int counter = 0;
            while (currentNode != null && !index.equals(counter)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                counter++;
            }

            if (currentNode != null) {
                newNode.setNext(currentNode);
                previousNode.setNext(newNode);
            }

            if (currentNode == null && index <= counter) {
                previousNode.setNext(newNode);
            }
        }
    }

    public void delete(Integer data) {
        Node currentNode = head;
        Node prevNode = null;

        if (currentNode != null && currentNode.getData().equals(data)) {
            head = currentNode.getNext();
        } else {
            while (currentNode != null && !currentNode.getData().equals(data)) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }

            if (currentNode != null) {
                prevNode.setNext(currentNode.getNext());
            }
        }
    }

    public void deleteAtIndex(Integer index) {
        Node currentNode = head;
        Node prevNode = null;

        if (index == 0) {
            head = currentNode.getNext();
        } else {
            int counter = 0;
            while (currentNode != null && !index.equals(counter)) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
                counter++;
            }

            if (currentNode != null) {
                prevNode.setNext(currentNode.getNext());
            }
        }
    }

    public String toString() {
        StringBuilder list = new StringBuilder("[");
        Node currentNode = head;
        while (currentNode != null) {
            list.append(currentNode.getData()).append(",");
            currentNode = currentNode.getNext();
        }
        list.append("]");
        return list.toString();
    }

    public Iterator<Integer> iterator() {
        return new CustomIterator(this);
    }

    private class CustomIterator implements Iterator<Integer> {
        Node current;

        private CustomIterator(SinglyLinkedList list) {
            this.current = list.head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Integer next() {
            Integer data = current.getData();
            current = current.getNext();
            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}