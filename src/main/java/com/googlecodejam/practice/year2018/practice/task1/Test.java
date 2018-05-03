package com.googlecodejam.practice.year2018.practice.task1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class Test {

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 5;

        Node head1 = new Node();
        head1.data = 1;

        head1.next = head;

        Node head2 = new Node();
        head2.data = 2;
        head2.next = head1;

        Insert(head2 , 4);
        Insert(null , 4);

//        System.out.println("test".substring(1, 1));


//        System.out.println(hasPair( new int[]{1, 2, 3, 9}, 8));
//        System.out.println(hasPair(new int[]{1, 2, 4, 4}, 8));
    }

    static class Node {
        int data;
        Node next;
    }

    static Node Insert(Node head,int data) {
// This is a "method-only" submission.
// You only need to complete this method.
        Node n = new Node();
        n.data = data;
        n.next = null;

        if (head == null)
            return n;

        Node p = head;

        while (p.next != null) {
            p = p.next;
        }

        p.next = n;

        return head;
    }

    /*
    O(n)
     */
    public static boolean hasPair(int[] arr, int sum) {

        Set<Integer> suplements = new HashSet<>();


        for (int value : arr) {
            if (suplements.contains(value))
                return true;

            suplements.add(sum - value);
        }


        return false;
    }

    /*
    with unsorted n(log n)
     */
    public static boolean hasPair2(int[] arr, int sum) {

        int low = 0;
        int height = arr.length - 1;

        while (low < height) {
            int s = arr[low] + arr[height];
            if (s == sum) {
                return true;
            }

            if (s < sum) {
                low++;
            } else {
                height--;
            }
        }

        return false;
    }

    /*
    Solution O(n^2)
     */
    public static boolean hasPair1(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {

            int value1 = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (value1 + arr[j] == sum) {
                    return true;
                }
            }
        }

        return false;
    }
}
