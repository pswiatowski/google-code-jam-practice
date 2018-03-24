package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Lists;

import java.util.List;

public class Airport {

    private int airportId;
    private List<Airport> connections = Lists.newLinkedList();
    private AirportState state = AirportState.RUNNNING;


    public Airport(int airportId) {
        this.airportId = airportId;
    }

    public void addConnection(Airport airportConnection) {
        connections.add(airportConnection);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportId=" + airportId +
                '}';
    }

    public Integer getId() {
        return airportId;
    }
}
