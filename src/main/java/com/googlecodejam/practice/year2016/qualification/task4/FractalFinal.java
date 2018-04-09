package com.googlecodejam.practice.year2016.qualification.task4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FractalFinal {

    public void main3(String[] args) {


        int number = 1;
        int C = 0; // put C here
        int K = 0; // put K here


        for (int i = 1; i <= C ; i++) {
            number = number * K + 1;
        }

        int not_allowed = 1;

        for (int i = 2; i <= Math.pow(K, C) ; i++) {
            if( i != not_allowed) {

            } else {
                number += not_allowed;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();

        for (long i = 1; i <= t; ++i) {

            int K = in.nextInt();
            int C = in.nextInt();
            int S = in.nextInt();

            if (C == 1) {
                if (K != S) {
                    System.out.println();
                    System.out.print("Case #" + i + ": " + "IMPOSSIBLE");
                } else {
                    System.out.println();
                    System.out.print("Case #" + i + ":");
                    for (int l = 1; l <= K; l++) {
                        System.out.print(" " + l);
                    }
                }
            } else {
                if (K == 1) {
                    System.out.println();
                    System.out.print("Case #" + i + ": " + "1");
                } else {

                    int conditionToStop = (int) Math.ceil((double) K / 2);

                    if (conditionToStop > S) {
                        System.out.println();
                        System.out.print("Case #" + i + ": " + "IMPOSSIBLE");
                    } else {

                        System.out.println();
                        System.out.print("Case #" + i + ":");

                        int found = 0;
                        int start = 2;

                        System.out.print(" " + start);
                        found++;

                        while (found < conditionToStop) {

                            int tail = (K * (start)) + (start + 2);
                            if (tail >= ((int) Math.pow(K, C))) {
                                System.out.print(" " + ((int) Math.pow(K, C)));
                                break;
                            } else {
                                System.out.print(" " + tail);
                            }
                            found++;
                            start = start +  2;
                        }

                    }
                }
            }


        }
    }
}
