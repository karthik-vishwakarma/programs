package com.kk.linkedlist;

// Merge Two Sorted Linked Lists
//You are given two sorted linked lists. You have to merge them to produce a combined sorted linked list. You need to return the head of the final linked list.
//Note:
//The given linked lists may or may not be null.
//For example:
//If the first list is: 1 -> 4 -> 5 -> NULL and the second list is: 2 -> 3 -> 5 -> NULL The final list would be: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> NULL
//Input Format:
//The first line of input contains an integer 'T' representing the number of test cases or queries to be processed. Then the test case follows. The first line of each test case contains the elements of the first linked list separated by a single space and terminated by -1. Hence, -1 would never be a list element. The second line of each test case contains the elements of the second linked list separated by a single space and terminated by -1.
//Output Format:
//For each test case, print the final linked list. The elements of the linked list must be separated by a single space and terminated by -1. Print output of each test case in a separate line.
//Note:
//You are not required to print the expected output, it has already been taken care of. Just implement the function.
//Constraints:
//1 <= T <= 10 1 <= L <= 10^5 1 ≤ data ≤ 10^6 and data != -1 Where L is the number of nodes in either of the two Linked List. Time Limit: 1 sec
//Follow-up:
//Try to solve this problem in linear time complexity and constant space complexity.

public class MergeTwoSortedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private static class MergeLists {
        Node head;

        public void add(Node node) {
            if (head == null) head = node;
            else {
                Node temp = head;
                while (temp.next != null) temp = temp.next;
                temp.next = node;
            }
        }
    }

    private static class LinkedListUtils {
        public static Node sortedMerge(Node head1, Node head2) {
            if (head1 == null) return head2;
            if (head2 == null) return head1;

            if (head1.data < head2.data) {
                head1.next = sortedMerge(head1.next, head2);
                return head1;
            } else {
                head2.next = sortedMerge(head1, head2.next);
                return head2;
            }
        }
    }

    public static void main(String[] args) {
        //Input: a: 5->10->15, b: 2->3->20
        //Output: 2->3->5->10->15->20
        MergeLists mergeList1 = new MergeLists();
        mergeList1.add(new Node(5));
        mergeList1.add(new Node(10));
        mergeList1.add(new Node(15));

        MergeLists mergeList2 = new MergeLists();
        mergeList2.add(new Node(2));
        mergeList2.add(new Node(3));
        mergeList2.add(new Node(20));
        Node node = LinkedListUtils.sortedMerge(mergeList1.head, mergeList2.head);
        System.out.println("Merged Linked List is:");
        printList(node);
    }

    private static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
