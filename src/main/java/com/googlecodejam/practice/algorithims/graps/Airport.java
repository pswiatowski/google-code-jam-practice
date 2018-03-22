package com.googlecodejam.practice.algorithims.graps;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

public class Airport {

    private int airportId;
    private List<Airport> connections = Lists.newLinkedList();
    private AirportState state = AirportState.RUNNNING;
    private boolean visited = false;


    public Airport(int airportId) {
        this.airportId = airportId;
    }

    public void addConnection(Airport airportConnection) {
        connections.add(airportConnection);
    }

    public List<Airport> getConnections() {
        return connections;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportId=" + airportId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return airportId == airport.airportId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(airportId);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Integer getId() {
        return airportId;
    }

    public void addConnection(List<Airport> connections) {
        this.connections.addAll(connections);
    }

    public boolean hasConnection(Airport airport) {
        return this.connections.contains(airport);
    }
}
