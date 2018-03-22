package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Maps;

import java.util.Map;

public class Airports {

    Map<Integer, Airport> airports = Maps.newLinkedHashMap();

    public void add(Airport airport) {

        if (airports.containsKey(airport.getId())) {
            Airport airport1 = airports.get(airport.getId());
            airport1.addConnection(airport.getConnections());
            airports.put(airport.getId(), airport1);
        } else {
            airports.put(airport.getId(), airport);
        }
    }

    public Airport get(int airportId) {
        return airports.get(airportId);
    }

    @Override
    public String toString() {
        return "Airports{" +
                "airports=" + airports +
                '}';
    }

    public boolean contains(int airportId) {
        return airports.containsKey(airportId);
    }
}
