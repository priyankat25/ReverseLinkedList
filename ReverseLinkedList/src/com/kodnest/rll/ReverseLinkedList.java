package com.kodnest.rll;

import java.util.Scanner;

public class ReverseLinkedList {

	 // Define the Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Define the LinkedList class
    static class LinkedList {
        Node head;

        // Method to add a node to the end of the list
        void append(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }

        // Method to reverse the linked list
        void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next; // Store next node
                current.next = prev; // Reverse the current node's pointer
                prev = current;      // Move pointers one position ahead
                current = next;
            }
            head = prev; // Update head to the new first element
        }

        // Method to print the linked list
        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        System.out.println("Original Linked List:");
        list.printList();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.printList();

        scanner.close();
    }
}