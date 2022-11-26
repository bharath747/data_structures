package dataStructures;

import dataStructures.singlyLinkedList.SinglyLinkedList;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(8);
        list.add(15);
        list.add(17);

        list.add(5, 20);

        for (Integer data : list) {
            System.out.println(data);
        }

        System.out.println(list);

        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("3");
        stack.push("10");
        stack.push("6");
        stack.push("4");
        stack.push("8");

        System.out.println(stack.pop());
        System.out.println(stack);

    }
}
