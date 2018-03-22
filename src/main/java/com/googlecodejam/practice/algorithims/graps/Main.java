package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

            Airport airport;
            Airport airport2;


            if (airports.contains(aiportOne)) {
                airport = airports.get(aiportOne);
            } else {
                airport = new Airport(aiportOne);
                airports.add(airport);
            }

            if (airports.contains(aiportTwo)) {
                airport2 = airports.get(aiportTwo);
            } else {
                airport2 = new Airport(aiportTwo);
                airports.add(airport2);
            }

            airport.addConnection(airport2);
            airport2.addConnection(airport);
        }

        int startAiport = in.nextInt();
        int endAiport = in.nextInt();


        List<Airport> output = getAirports(airports, startAiport, endAiport);

//        System.out.println(airports);
        System.out.println(output);
    }

    @NotNull
    private static List<Airport> getAirports(Airports airports, int startAiport, int endAiport) {
        Queue<Airport> queue = Lists.newLinkedList();
        List<Airport> output = Lists.newLinkedList();
        Stack<Airport> pathStack = new Stack<>();

        Airport airport = airports.get(startAiport);
        airport.setVisited(true);
        queue.add(airport);

        while (!queue.isEmpty()) {
            Airport node = queue.poll();
            pathStack.add(node);

            if (node.getId() == endAiport) {
                break;
            }

            for (Airport childNode : node.getConnections()) {
                if (!childNode.isVisited()) {
                    childNode.setVisited(true);
                    queue.add(childNode);
                }
            }
        }

        Airport currentAirport = pathStack.pop();
        output.add(currentAirport);

        while (!pathStack.isEmpty()) {
            Airport airport2 = pathStack.pop();


            if (airports.get(currentAirport.getId()).hasConnection(airport2)) {
                output.add(airport2);
                currentAirport = airport2;

                if (airport2.getId() == startAiport) {
                    break;
                }

            }
        }

        Collections.reverse(output);
        return output;
    }
}
