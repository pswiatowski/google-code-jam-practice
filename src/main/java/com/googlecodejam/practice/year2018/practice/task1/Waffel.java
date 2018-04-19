package com.googlecodejam.practice.year2018.practice.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Waffel {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int R = in.nextInt();
            int C = in.nextInt();
            int H = in.nextInt();
            int V = in.nextInt();

            int numberOfPieces = (H+1) * (V+1);
            // allow number of pieces
            // 0 numberOfPieces numberOfPieces * 2 numberOfPieces * 3 till


            // number of cells = R * C



            // read chip
            int chipsRow = 0;
            int chipColumn = 0;


            int[] rows = new int[R];
            int[] columns = new int[C];

            for (int j = 0; j < R; j++) {

                char[] line = in.next().toCharArray();
                for (int l = 0; l < line.length; l++) {
                    if (line[l] == '@') {
                        chipsRow++;
                        rows[j] = chipsRow;
                        chipColumn++;

                        if (l == 0) {
                            columns[l] = columns[l] + 1;
                        } else {
                            columns[l] = columns[l] + chipColumn;
                        }
                    } else {
                        if (l != 0) {
                            columns[l] = columns[l] + chipColumn;
                        }
                    }
                }
                chipColumn = 0;
            }

            System.out.println();
            System.out.print("Case #" + i + ":");


            // how to split horizontal
            //




            System.out.println("Case #" + i + ": ");
            System.out.println("Case #" + columns);
            System.out.println("Case #" + rows);
        }
    }
}
