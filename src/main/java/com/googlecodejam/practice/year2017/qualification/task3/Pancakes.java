package com.googlecodejam.practice.year2017.qualification.task3;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;

public class Pancakes {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int numberOfDiners = in.nextInt();

            Queue<Integer> diners = Lists.newLinkedList();

            for (int j = 0; j < numberOfDiners; j++)
                diners.add(in.nextInt());


            int min = 0;
            while (!diners.isEmpty()) {
                Integer poll = diners.poll();

                int move = 1;
                while (poll > 1) {
                    int i1 = (int) Math.ceil((double) poll / 2);
                    diners.add(poll - i1);
                    move++;
                    poll = i1;
                }
                if (move > min) {
                    min = move;
                }


            }

            System.out.println("min " + min);

//            int[] counts = new int[1005];
//            for (int p : ps)
//                counts[p]++;
//
//            int min = 10000;
//            for (int lim = 1; lim <= counts.length; lim++) {
//                int moves = 0;
//                for (int m = 0; m < counts.length; m++)
//                    moves += ((m - 1) / lim) * counts[m];
//                if (moves + lim < min)
//                    min = moves + lim;
//            }


//            System.out.println("Case #" + i + ": " + min);


        }
    }
}
