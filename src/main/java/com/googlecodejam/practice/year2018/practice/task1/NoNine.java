package com.googlecodejam.practice.year2018.practice.task1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NoNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();

        for (int i = 1; i <= numberOfTestCases; ++i) {
            String start = in.next();
            String end = in.next();

            System.out.println("Case #" + i + ": " + start + " " + end);
            int counter = 2;    // 2 because we need to count Initial && Final
            while (!start.equals(end)) {
                int last = Character.getNumericValue(start.charAt(start.length() - 1));
                last++;
                start = start.substring(0, start.length() - 1) + last;
                if ((last < 9) && !divisibleByNine(start)) {
                    counter++;
                }
                if (last == 9) {
                    start = getNextNumberWithoutNine(start);
                }
            }
            System.out.println("Case #" + i + ": " + String.valueOf(counter));
        }
    }

    private static String getNextNumberWithoutNine(String number) {
        int position = number.length() - 1;
        int previous = Character.getNumericValue(number.charAt(position - 1)) + 1;
        String after = "0";
        while (previous == 9) {
            position--;
            if (position > 0) {
                previous = Character.getNumericValue(number.charAt(position - 1)) + 1;
                after += "0";
            } else {
                return "10" + after;
            }
        }
        return number.substring(0, position - 1) + String.valueOf(previous) + after;
    }

    private static boolean divisibleByNine(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        return (sum % 9) == 0;
    }
}