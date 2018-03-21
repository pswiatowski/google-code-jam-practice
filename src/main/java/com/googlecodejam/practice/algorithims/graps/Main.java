package com.googlecodejam.practice.algorithims.graps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfCitites = in.nextInt();
        int numberOfFlightRoutes = in.nextInt();
        int switchStateTime = in.nextInt();
        int travelTime = in.nextInt();

        Airports airports = new Airports();

        for (int i = 0; i < numberOfFlightRoutes; i++) {
            int aiportOne = in.nextInt();
            int aiportTwo = in.nextInt();

            Airport airport = new Airport(aiportOne);
            Airport airport2 = new Airport(aiportTwo);

            airport.addConnection(airport2);
            airport2.addConnection(airport);

            airports.add(airport);
            airports.add(airport2);
        }

        int startAiport = in.nextInt();
        int endAiport = in.nextInt();





        System.out.println(airports);
    }
}
