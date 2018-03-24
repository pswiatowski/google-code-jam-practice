package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Maps;

import java.util.Map;

public class Airports {

    Map<Integer, Airport> airports = Maps.newLinkedHashMap();

    public void add(Airport airport) {
        airports.put(airport.getId(), airport);
    }

    @Override
    public String toString() {
        return "Airports{" +
                "airports=" + airports +
                '}';
    }
}
