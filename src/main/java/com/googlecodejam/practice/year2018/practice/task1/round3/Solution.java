package com.googlecodejam.practice.year2018.practice.task1.round3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (long i = 1; i <= t; ++i) {

      int A = in.nextInt();

      boolean[][] matrix = new boolean[1001][1001];
      Set<Integer> values = new HashSet<>();

      int m = 10;
      int p = 10;

      int j = -1;
      int k = -1;

      int iteration = 0;
      while ((j != 0 && k != 0) && iteration < 1000) {
        System.out.println(m + " " + p);
        System.out.flush();

        j = in.nextInt();
        k = in.nextInt();

        if (j == 0 && k == 0) {
          break;
        }

        values.add(13 * j + k);
        iteration++;


        if (values.size() == 9) {
          m = 10;
          p = 12;
        } else if (values.size() == 15) {
          m = 11;
          p = 12;
        } else if (values.size() == 18) {
          m = 11;
          p = 10;
        } else if (values.size() == 20) {
          m = 14;
          p = 10;
        } else if (values.size() == 29) {
          m = 14;
          p = 12;
        } else if (values.size() == 35) {
          m = 17;
          p = 10;
        } else if (values.size() == 44) {
          m = 17;
          p = 12;
        } else if (values.size() == 50) {
          m = 20;
          p = 10;
        } else if (values.size() == 59) {
          m = 20;
          p = 12;
        } else if (values.size() == 65) {
          m = 23;
          p = 10;
        } else if (values.size() == 74) {
          m = 23;
          p = 12;
        }else if (values.size() == 80) {
          m = 26;
          p = 10;
        } else if (values.size() == 89) {
          m = 26;
          p = 12;
        } else if (values.size() == 95) {
          m = 29;
          p = 10;
        } else if (values.size() == 104) {
          m = 29;
          p = 12;
        }else if (values.size() == 110) {
          m = 32;
          p = 10;
        } else if (values.size() == 119) {
          m = 32;
          p = 12;
        } else if (values.size() == 125) {
          m = 35;
          p = 10;
        } else if (values.size() == 134) {
          m = 35;
          p = 12;
        }else if (values.size() == 140) {
          m = 38;
          p = 10;
        } else if (values.size() == 149) {
          m = 38;
          p = 12;
        } else if (values.size() == 155) {
          m = 41;
          p = 10;
        } else if (values.size() == 164) {
          m = 41;
          p = 12;
        }else if (values.size() == 170) {
          m = 44;
          p = 10;
        } else if (values.size() == 179) {
          m = 44;
          p = 12;
        } else if (values.size() == 185) {
          m = 47;
          p = 10;
        } else if (values.size() == 194) {
          m = 47;
          p = 12;
        }else if (values.size() == 200) {
          m = 50;
          p = 10;
        } else if (values.size() == 209) {
          m = 50;
          p = 12;
        } else if (values.size() == 215) {
          m = 53;
          p = 10;
        }
      }

    }
  }
}
