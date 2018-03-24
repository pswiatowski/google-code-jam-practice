package com.googlecodejam.practice.year2017.qualification.task4;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by pswiatowski on 3/19/18.
 */
public class FashionShow {

  public static void main(String[] args) {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    long t = in.nextInt();

    for (long i = 1; i <= t; ++i) {

      int numberOfRows = in.nextInt();

      boolean[] rows = new boolean[numberOfRows + 1];
      boolean[] columns = new boolean[numberOfRows + 1];

      boolean[] diagonals = new boolean[(numberOfRows * 2)];
      boolean[] reverseDiagonals = new boolean[(numberOfRows * 2)];

      int numberOfLines = in.nextInt();

      List<Output> outputsToReview = Lists.newArrayList();

      boolean[][] help = new boolean[numberOfRows+1][numberOfRows+1];

      for (int j = 1; j <= numberOfLines; j++) {
        String next = in.next();
        int k = in.nextInt();
        int m = in.nextInt();

        outputsToReview.add(new Output(k, m, next));
        help[k][m] = true;

        int diagonal = calculateDiagonalNumber(k, m, numberOfRows);
        int reverse = calculateReverseDiagonalNumber(k, m, numberOfRows);

        if (next.equals("o")) {
          rows[k] = true;
          columns[m] = true;
          diagonals[diagonal] = true;
          reverseDiagonals[reverse] = true;
        } else if (next.equals("+")) {
          diagonals[diagonal] = true;
          reverseDiagonals[reverse] = true;
        } else {
          rows[k] = true;
          columns[m] = true;
        }
      }

      int finalScore = 0;

      List<Output> outputs = Lists.newArrayList();

      Map<Integer, Integer> integerIntegerMap = Maps.newHashMap();
      for (int q = 1; q<= numberOfRows; q++ ) {
        integerIntegerMap.put(q, 0);
      }

      for (Output output : outputsToReview) {

        int k = output.getRow();
        int m = output.getColumn();
        String charr = output.getCharr();

        Integer integer = integerIntegerMap.get(k);
        integer ++;
        integerIntegerMap.put(k, integer);

        if (charr.equals("o")) {

          finalScore += 2;
        } else {

          int diagonal = calculateDiagonalNumber(k, m, numberOfRows);
          int reverse = calculateReverseDiagonalNumber(k, m, numberOfRows);

          if (charr.equals("+")) {

            if (!rows[k] && !columns[m]) {
              outputs.add(new Output(k, m, "o"));
              finalScore += 2;
              rows[k] = true;
              columns[m] = true;
              diagonals[diagonal] = true;
              reverseDiagonals[reverse] = true;
            } else {
              finalScore += 1;
            }
          } else {
            if (!diagonals[diagonal] && !reverseDiagonals[reverse]) {
              outputs.add(new Output(k, m, "o"));
              finalScore += 2;
              rows[k] = true;
              columns[m] = true;
              diagonals[diagonal] = true;
              reverseDiagonals[reverse] = true;
            } else {
              finalScore += 1;
            }
          }
        }
      }

      Map<Integer, Integer> sortedMap = new FashionShow().sortMap(integerIntegerMap);


      for (Map.Entry<Integer, Integer> tr : sortedMap.entrySet()) {

        Integer k = tr.getKey();

        for (int m = 1; m <= numberOfRows; m++) {

          if (!help[k][m]) {
            int diagonal = calculateDiagonalNumber(k, m, numberOfRows);
            int reverse = calculateReverseDiagonalNumber(k, m, numberOfRows);

            // try yo put o
            if (!rows[k] && !columns[m] && !diagonals[diagonal] && !reverseDiagonals[reverse]) {

              outputs.add(new Output(k, m, "o"));
              finalScore += 2;
              rows[k] = true;
              columns[m] = true;
              diagonals[diagonal] = true;
              reverseDiagonals[reverse] = true;
            }
            // try to put +
            else if (!diagonals[diagonal] && !reverseDiagonals[reverse]) {
              outputs.add(new Output(k, m, "+"));
              finalScore += 1;
              diagonals[diagonal] = true;
              reverseDiagonals[reverse] = true;
            }
            // try to put x
            else if (!rows[k] && !columns[m]) {
              outputs.add(new Output(k, m, "x"));
              finalScore += 1;
              rows[k] = true;
              columns[m] = true;
            }
          }
          else {
            System.out.println("s " + k + " " + m);
          }
        }
      }

      System.out.println("Case #" + i + ": " + finalScore + " " + outputs.size());
      for (Output output : outputs) {
        System.out.println("" + output.getCharr() + " " + output.getRow() + " " + output.getColumn());
      }

//      System.out.println(outputs);
    }
  }

  private Map<Integer, Integer> sortMap(Map<Integer, Integer> integerIntegerMap) {
    return integerIntegerMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
  }

  private static int calculateDiagonalNumber(int row, int column, int N) {
    int min = Math.min(row, column);
    int diff = min;

    int x = row - diff;
    int y = column - diff;

    return (N) - x + y;
  }

  private static int calculateReverseDiagonalNumber(int row, int column, int N) {
    int x = N - row;
    int y = column;

    int x1;
    int y1;
    if (Math.min(x, y) == x) {
      x1 = row + x;
      y1 = column - x;
    } else {
      x1 = row + y;
      y1 = column - y;
    }

    return (x1 + y1) - 1;
  }

  static class Output {
    private int row;
    private int column;
    private String charr;

    public Output(int row, int column, String charr) {

      this.row = row;
      this.column = column;
      this.charr = charr;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }

    public String getCharr() {
      return charr;
    }

    @Override
    public String toString() {
      return "Output{" +
             "row=" + row +
             ", column=" + column +
             ", charr='" + charr + '\'' +
             '}';
    }
  }
}
