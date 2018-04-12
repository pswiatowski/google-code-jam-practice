package com.googlecodejam.practice.year2017.round1A.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AlphabetCake {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int row = in.nextInt();
            int column = in.nextInt();

            String[][] output = new String[row][column];

            int global = -1;
            for (int j = 0; j < row; j++) {

                String letterToRemember = "";
                int indexToRemember = -1;

                String letter = in.next();
                char[] chars = letter.toCharArray();

                for (int m = 0; m < column; m++) {

                    if (String.valueOf(chars[m]).equals("?")) {
                        if (!letterToRemember.isEmpty()) {
                            output[j][m] = letterToRemember;
                        }
                        if (indexToRemember == -1) {
                            indexToRemember = m;
                        }
                    } else {
                        if (global == -1) {

                            if (j == 0) {
                                global = 1;
                            } else {
                                global = 0;
                            }
                        }

                        if (!letterToRemember.isEmpty()) {
                            indexToRemember = -1;
                        }
                        letterToRemember = String.valueOf(chars[m]);
                        output[j][m] = String.valueOf(chars[m]);

                        if (indexToRemember != -1) {
                            for (int k = indexToRemember; k < m; k++) {
                                output[j][k] = letterToRemember;
                            }
                        }
                    }
                }

                if (global > 0) {
                    if (letterToRemember.isEmpty() && indexToRemember == 0) {
                        output[j] = output[j - 1];
                    }
                } else if (global == 0) {
                    for (int p = 0; p < j; p++) {
                        output[p] = output[j];
                        global = 1;
                    }
                }
            }



            System.out.println("Case #" + i + ": ");

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    System.out.print(output[j][k]);
                }
                System.out.println();
            }

        }
    }
}
