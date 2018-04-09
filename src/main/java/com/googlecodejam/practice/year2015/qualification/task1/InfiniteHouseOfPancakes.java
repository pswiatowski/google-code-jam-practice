package com.googlecodejam.practice.year2015.qualification.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * width                     minimum                         maximum
 * <p>
 * SIGNED
 * byte:     8 bit                        -128                            +127
 * short:   16 bit                     -32 768                         +32 767
 * int:     32 bit              -2 147 483 648                  +2 147 483 647
 * long:    64 bit  -9 223 372 036 854 775 808      +9 223 372 036 854 775 807
 * <p>
 * UNSIGNED
 * char     16 bit                           0                         +65 535
 */
public class InfiniteHouseOfPancakes {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {

            int D = in.nextInt();
            int[] pancakes = new int[D];
            for (int j = 0; j < D; j++) {
                pancakes[j] = in.nextInt();
            }

            int min = 9; // data set max value
            // complexity space: O(n)
            // complexity time: O(n)
            for (int j = 1; j <= 9; j++) {

                int cut = 0;
                for (int m = 0; m < pancakes.length; m++) {
                    cut += ((int) Math.ceil((double) pancakes[m] / j)) - 1;
                }

                if ((cut + j) < min) {
                    min = cut + j;
                }
            }

            System.out.println("Case #" + i + ": " + min);
        }
    }
}
