package com.googlecodejam.practice.year2016.round1C.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Senate {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();

        for (int i = 1; i <= numberOfTestCases; ++i) {

            int numberOfParties = in.nextInt();

            PriorityQueue<AbstractMap.SimpleEntry<Character, Integer>> parties =
                    new PriorityQueue<>(numberOfParties,
                            (o1, o2) -> o1.getValue().compareTo(o2.getValue()) * (-1));

            char partyName = 'A';
            int totalSenators = 0;

            for (int p = 0; p < numberOfParties; p++) {
                int numberOfSenators = in.nextInt();

                parties.add(new AbstractMap.SimpleEntry<>(partyName, numberOfSenators));
                totalSenators += numberOfSenators;
                partyName++;
            }

            System.out.print("Case #" + i + ":");

            while (!parties.isEmpty()) {
                System.out.print(" ");

                totalSenators = removeOneSenator(parties, totalSenators);

                if ((totalSenators > 2 && ((float) parties.peek().getValue() - 1) / (totalSenators - 1) <= 0.5)
                        || (totalSenators == 1)) {
                    totalSenators = removeOneSenator(parties, totalSenators);
                }

            }

            System.out.println();
        }
    }

    private static int removeOneSenator(PriorityQueue<AbstractMap.SimpleEntry<Character, Integer>> parties, int totalSenators) {
        AbstractMap.SimpleEntry<Character, Integer> firstParty = parties.poll();

        firstParty.setValue(firstParty.getValue() - 1);

        if (firstParty.getValue() > 0) {
            parties.add(firstParty);
        }

        totalSenators--;

        System.out.print(firstParty.getKey());
        return totalSenators;
    }

}
