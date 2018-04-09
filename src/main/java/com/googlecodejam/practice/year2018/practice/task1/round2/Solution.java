package com.googlecodejam.practice.year2018.practice.task1.round2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (long i = 1; i <= t; ++i) {

      int numberOfNumbers = in.nextInt();
      ArrayList<Integer> odds = new ArrayList<>();
      ArrayList<Integer> evens = new ArrayList<>();

      for (int j = 0; j < numberOfNumbers; j++) {
        int value = in.nextInt();
        if (j % 2 == 0) {
          odds.add(value);
        } else {
          evens.add(value);
        }
      }

      Collections.sort(odds);
      Collections.sort(evens);

      String result = "OK";
      int pointer = 0;
      for (int j = 0; j < evens.size(); j++) {
        if (evens.get(j) < odds.get(j)) {
          result = String.valueOf(pointer);
          break;
        } else if ((j + 1 < odds.size()) && odds.get(j + 1) < evens.get(j)) {
          result = String.valueOf(pointer + 1);
          break;
        }
        pointer += 2;
      }

      System.out.println("Case #" + i + ": " + result);
    }
  }
}
