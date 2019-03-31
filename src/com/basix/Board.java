package com.basix;

import com.ships.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    public Board(Integer N) {
        this.N = N;
    }

    public void addShip(Ship ship) {
        ships.add(ship);

        for (String cell : ship.getLocation()) {
            locations.put(cell, ship);
        }
    }

    public boolean hit(String cell) {
        boolean hit = false;

        Ship ship = locations.get(cell);
        if (ship != null) {
            ship.hit(cell);
        }

        return hit;
    }

    public void showHits() {
        int sunk = 0;
        int hit = 0;

        for (Ship ship : ships) {
            if (ship.isSunk()) sunk++;
            else if (ship.isHit()) hit++;
        }

        System.out.printf("Ships sunk:%d\n", sunk);
        System.out.printf("Ships hits:%d\n", hit);
    }

    private Board() {
        N = 0;
    }

    private final Integer N;
    private Map<String, Ship> locations = new HashMap<>();
    private List<Ship> ships = new ArrayList<>();
}
