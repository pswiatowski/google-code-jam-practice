package com.googlecodejam.practice.year2017.qualification.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pancake {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();

        for (long i = 1; i <= t; ++i) {

            String pancake = in.next();
            int panSize = in.nextInt();


            String solution;
            int counter = 0;

            char[] chars = pancake.toCharArray();

            for (int j = 0; j <= chars.length - panSize; j++) {
                if (String.valueOf(chars[j]).equals("-")) {
                    // update
                    for (int m = j; m < j + panSize; m++) {

                        if (String.valueOf(chars[m]).equals("-")) {
                            chars[m] = '+';
                        } else {
                            chars[m] = '-';
                        }
                    }
                    counter++;
                }
            }

            solution = String.valueOf(counter);

            //verify the leftovers
            for (int j = (chars.length - panSize); j < chars.length; j++) {
                if (String.valueOf(chars[j]).equals("-")) {
                    solution = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + solution);
        }
    }
}
