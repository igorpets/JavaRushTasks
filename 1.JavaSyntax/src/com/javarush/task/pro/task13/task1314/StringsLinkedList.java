package com.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        Node node = new Node();
        node.value = value;
        if (first.next == null) {
            first.next = node;
            last.prev = node;
            return;
        }

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        if (index < 0) return null;
        //напишите тут ваш код
        Node nxt = first.next;
        index--;
        while (nxt != null && index >= 0) {
            index--;
            nxt = nxt.next;
        }
        if (nxt == null) return null;
        return nxt.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
