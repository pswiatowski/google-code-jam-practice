package com.googlecodejam.practice.year2016.qualification.task1;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingSheep {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();


        for (long i = 1; i <= t; ++i) {

            String number = in.next();

            int numberAsInteger = Integer.parseInt(number);

            if (numberAsInteger != 0) {
                HashSet<Character> integers = Sets.newHashSet('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

                Set<Character> charsSet = number.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
                integers.removeAll(charsSet);

                int n = 2;
                int finalIn = numberAsInteger;

                while (!integers.isEmpty()) {
                    finalIn = n * numberAsInteger;
                    Set<Character> charsSet1 = String.valueOf(finalIn).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
                    integers.removeAll(charsSet1);
                    n++;
                }

                System.out.println("Case #" + i + ": " + finalIn);
            } else {
                System.out.println("Case #" + i + ": " + "INSOMNIA");
            }

        }
    }
}
