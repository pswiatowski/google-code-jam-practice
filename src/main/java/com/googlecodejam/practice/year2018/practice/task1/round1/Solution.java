package com.googlecodejam.practice.year2018.practice.task1.round1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 1; i <= t; ++i) {

      long maxDamage = in.nextLong();
      String sequence = in.next();

      int hackCounter = 0;

      PriorityQueue<Long> attacks = new PriorityQueue<>(new Comparator<Long>() {
        @Override
        public int compare(Long x, Long y) {
          return (x > y) ? -1 : ((x == y) ? 0 : 1);
        }
      });

      char[] moves = sequence.toCharArray();

      long strength = 1;
      long numberOfC = 0;
      long numberOfS = 0;
      long damage = 0;

      for (int j = 0; j < moves.length; j++) {
        if (moves[j] == 'S') {
          damage += strength;
          numberOfS++;
          if (strength > 1) {
            attacks.add(strength);
          }
        } else {
          strength *= 2;
          numberOfC++;
        }
      }

      if ((damage > maxDamage)) {
        if ((numberOfC == 0 || numberOfS > maxDamage)) {
          System.out.println("Case #" + i + ": IMPOSSIBLE");
        } else {

          while (!attacks.isEmpty()) {
            Long number = attacks.poll();
            number /= 2;
            hackCounter++;
            damage -= number;

            if (damage <= maxDamage) {
              break;
            }
            if (number > 1) {
              attacks.add(number);
            }
          }

          System.out.println("Case #" + i + ": " + hackCounter);
        }

      } else {
        System.out.println("Case #" + i + ": 0");
      }

    }
  }
}
