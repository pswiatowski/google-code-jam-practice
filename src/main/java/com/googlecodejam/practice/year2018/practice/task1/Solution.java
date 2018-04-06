package com.googlecodejam.practice.year2018.practice.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by pswiatowski on 3/31/18.
 */
public class Solution {

  private static String CORRECT = "CORRECT";
  private static String TOO_SMALL = "TOO_SMALL";
  private static String TOO_BIG = "TOO_BIG";
  private static String WRONG_ANSWER = "WRONG_ANSWER";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 1; i <= t; ++i) {

      int A = in.nextInt();
      int B = in.nextInt();
      int N = in.nextInt();

      int current = A + (int) Math.ceil((double) (B - A) / 2);
      function(current, A, B, in, N);
    }

    System.exit(0);
  }

  private static void function(int current, int A, int B, Scanner in, int N) {

    System.out.println(current);
    System.out.flush();

    String input = in.next();

    if (input.equals(WRONG_ANSWER)) {
      System.err.println(WRONG_ANSWER);
      System.err.flush();
      System.exit(1);
    }

    if (input.equals(CORRECT)) {
      return;
    }

    if (input.equals(TOO_BIG)) {
      B = current;
      int c = B - (int) Math.ceil((double) ((B - A)) / 2);
      function(c, A, B, in, N);
    } else if (input.equals(TOO_SMALL)) {
      A = current;
      int c = A + (int) Math.ceil((double) (B - A) / 2);
      function(c, A, B, in, N);
    }
  }
}
