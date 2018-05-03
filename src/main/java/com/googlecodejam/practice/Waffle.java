package com.googlecodejam.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Waffle {

    /*

    INPUT
6
3 6 1 1
.@@..@
.....@
@.@.@@
4 3 1 1
@@@
@.@
@.@
@@@
4 5 1 1
.....
.....
.....
.....
4 4 1 1
..@@
..@@
@@..
@@..
3 4 2 2
@.@@
@@.@
@.@@
3 4 1 2
.@.@
@.@.
.@.@

     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int r = in.nextInt();
            int c = in.nextInt();
            int h = in.nextInt();
            int v = in.nextInt();

            int[] totalInCol = new int[c];
            int[] totalInRow = new int[r];


            int totalNumber = 0;
            for (int j = 0; j < r; j++) {
                char[] charsrows = in.next().toCharArray();
                for (int k = 0; k < charsrows.length; k++) {
                    if ('@'==charsrows[k]) {
                        totalInCol[k]++;
                        totalInRow[j]++;

                        totalNumber++;
                    }
                }
            }

            int cookiesPerCutInCol = totalNumber/(v+1);

            boolean col = canBeDivided(totalInCol, cookiesPerCutInCol);
            if (!col) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int cookiesPerCutInRow = totalNumber/(h+1);
            boolean row = canBeDivided(totalInRow, cookiesPerCutInRow);
            if (!row) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            System.out.println("Case #" + i + ": POSSIBLE");
        }
    }

    private static boolean canBeDivided(int[] input, int cookiesPerCut) {
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            sum += input[i];

            if (sum > cookiesPerCut)
                return false;
            else if (sum == cookiesPerCut)
                sum = 0;
        }

        return sum == 0;
    }
}
