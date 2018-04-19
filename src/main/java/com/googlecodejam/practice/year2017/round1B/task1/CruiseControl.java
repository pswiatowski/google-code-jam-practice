package com.googlecodejam.practice.year2017.round1B.task1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CruiseControl {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int finalDistance = in.nextInt();
            int numberOfHorses = in.nextInt();
            double maxEta = 0.0;

            for (int j = 0; j < numberOfHorses; j++) {
                int initialPositionOfHorse = in.nextInt();
                int velocityOfHorse = in.nextInt();

                double eta = (double) (finalDistance - initialPositionOfHorse) / velocityOfHorse;

                if (eta > maxEta) {
                    maxEta = eta;
                }
            }
            double velocityOfAnne = finalDistance / maxEta;

            System.out.println("Case #" + i + ": " + String.format("%.6f", velocityOfAnne).replace(",", "."));
        }
    }
}
