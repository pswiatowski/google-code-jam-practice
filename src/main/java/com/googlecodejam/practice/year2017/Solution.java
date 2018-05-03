package com.googlecodejam.practice.year2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }

    static class Stack {
        Node head;

        public void push(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();

        Stack stack = new Stack();

        for (int i = 1; i <= numberOfTestCases; ++i) {

            int command = in.nextInt();

            if (command == 1) {
                int number = in.nextInt();

                // put on the Stack
                stack.push(number);

            } else if (command == 2) {
                // delete peek
                stack.pop();
            } else {
                // print the highest on the stack
                System.out.println(stack.head.data);
            }
        }
    }
}