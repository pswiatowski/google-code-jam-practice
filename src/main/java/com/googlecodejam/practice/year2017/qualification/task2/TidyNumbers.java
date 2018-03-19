package com.googlecodejam.practice.year2017.qualification.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();


        for (long i = 1; i <= t; ++i) {

            String number = in.next();
            char[] chars = number.toCharArray();


            int indexToUpdate = -1;

            for (int j = chars.length - 1; j > 0; j--) {
                if ((int) chars[j] < (int) chars[j - 1]) {
                    int newNum = (int) chars[j - 1] - 1;
                    chars[j - 1] = (char) newNum;

                    indexToUpdate = j;
                }
            }

            if (indexToUpdate != -1) {
                // update from index
                for (int j = indexToUpdate; j < chars.length; j++) {
                    chars[j] = '9';
                }
            }

            System.out.println("Case #" + i + ": " + String.copyValueOf(chars).replaceFirst("^0*", ""));
        }
    }
}

