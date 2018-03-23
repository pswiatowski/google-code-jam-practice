package com.googlecodejam.practice.year2017.qualification.task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BathroomStalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();

        for (long i = 1; i <= t; ++i) {

            long numberOfStalls = in.nextLong();
            long numberOfPeople = in.nextLong();

            long highestOneBit = Long.highestOneBit(numberOfPeople);
            long numberOfStallsInTheLastTreeLevel = numberOfStalls / highestOneBit;

            long numberOfStallsForTheLastPerson =
                    (numberOfStalls % highestOneBit) >= (numberOfPeople - highestOneBit)
                            ? numberOfStallsInTheLastTreeLevel
                            : numberOfStallsInTheLastTreeLevel - 1;

            long max = numberOfStallsForTheLastPerson / 2;
            long min = numberOfStallsForTheLastPerson % 2 == 0 ? max - 1 : max;

            System.out.println("Case #" + i + ": " + max + " " + min);
        }
    }
}

//            int d = Long.toBinaryString(numberOfPeople).length() - 1;
//            long prev = (numberOfStalls - numberOfPeople + Long.highestOneBit(numberOfPeople)) >> d;
//
//            long max1 = prev / 2;
//            long min1 = (prev - 1) / 2;
