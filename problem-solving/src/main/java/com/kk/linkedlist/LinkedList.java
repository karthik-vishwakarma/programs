package com.kk.linkedlist;

public class LinkedList {
    public static void main(String[] args) {
        Integer a = 10;
        LList<Integer> lList = new LList<>();
        lList.add(a);
    }


    static class LList<T> {
        private Node<T> node;

        public void add(T e) {
            if (node == null) {
                node = new Node<>(e);
            } else {
                Node<T> node2 = new Node<>(e);
                Node<T> temp = node;
                while (temp.getRef() != null) {
                    temp = temp.getRef();
                }
                temp.setRef(node2);
            }
        }
    }

    static class Node<T> {
        private T value;
        private Node<T> ref;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getRef() {
            return ref;
        }

        public void setRef(Node<T> ref) {
            this.ref = ref;
        }
    }
}



