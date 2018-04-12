package com.googlecodejam.practice.year2016.round1C.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SenateEvacuation {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int numberOfparties = in.nextInt();


            int totalNumber = 0;
            PriorityQueue<Partie> parties = new PriorityQueue<>((x, y) -> (x.numberOfSenators > y.numberOfSenators) ? -1 : ((x.numberOfSenators == y.numberOfSenators) ? 0 : 1));


            char partie = 'A';
            for (int j = 0; j < numberOfparties; j++) {
                int numberOfSenators = in.nextInt();
                totalNumber += numberOfSenators;

                parties.add(new Partie(partie, numberOfSenators));
                partie++;
            }

            System.out.print("Case #" + i + ":");

            while (!parties.isEmpty()) {

                Partie poll = parties.poll();
                totalNumber--;
                poll.numberOfSenators--;

                if (poll.numberOfSenators > 0) {
                    parties.add(poll);
                }

                if (!parties.isEmpty() && (parties.peek().numberOfSenators > (double) totalNumber / 2)) {
                    Partie poll1 = parties.poll();
                    totalNumber--;
                    poll1.numberOfSenators--;

                    if (poll1.numberOfSenators > 0) {
                        parties.add(poll1);
                    }

                    System.out.print(" " + poll.partie + poll1.partie);
                } else {
                    System.out.print(" " + poll.partie);
                }
            }
            System.out.println();
        }
    }

    private static class Partie {
        public char partie;
        public int numberOfSenators;

        public Partie(char partie, int numberOfSenators) {
            this.partie = partie;
            this.numberOfSenators = numberOfSenators;
        }
    }


}
