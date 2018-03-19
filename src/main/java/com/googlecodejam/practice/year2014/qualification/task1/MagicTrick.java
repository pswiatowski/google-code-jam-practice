package com.googlecodejam.practice.year2014.qualification.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicTrick {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        // TODO
        // read only row to the set
        // compare sets
        /*
        Set<String> s1; Set<String> s2; s1.retainAll(s2);
         */
        for (long i = 1; i <= t; ++i) {

            Integer firstRow = in.nextInt();
            Integer[][] firstRound = getCards(in);

            // get values
            List<Integer> firstRoundList = Arrays.asList(firstRound[firstRow - 1]);


            int secondRow = in.nextInt();
            Integer[][] secondRound = getCards(in);


            List<Integer> secondRoundList = Arrays.asList(secondRound[secondRow - 1]);


            // define the magician fault
            int counter = 0;
            int solution = -1;
            for (int number : firstRoundList) {
                if (secondRoundList.contains(number)) {
                    counter++;
                    solution = number;
                }
            }

            String sol;
            if (counter == 0) {
                sol = "Volunteer cheated!";
            } else if (counter > 1) {
                sol = "Bad magician!";
            } else {
                sol = String.valueOf(solution);
            }


            System.out.println("Case #" + i + ": " + sol);
        }
    }

    private static Integer[][] getCards(Scanner in) {
        Integer[][] cards = new Integer[4][4];
        for (int j = 0; j < 4; j++) {
            for (int m = 0; m < 4; m++) {
                cards[j][m] = in.nextInt();
            }
        }
        return cards;
    }

}