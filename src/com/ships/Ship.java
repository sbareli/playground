package com.ships;

import java.util.HashSet;
import java.util.Set;

public class Ship {

    static final char letters[] = {
            'A','B','C','D','E','F','G','H','I','J','K'
    };

    public Ship(String start, String end) {
        char startCell[] = start.toCharArray();
        char endCell[] = end.toCharArray();

        Integer r1 = Character.getNumericValue(startCell[0]);
        Integer c1 = findChar(startCell[1]);

        Integer r2 = Character.getNumericValue(endCell[0]);
        Integer c2 = findChar(endCell[1]);

        for (Integer r=r1; r<=r2; ++r) {
            for (Integer c=c1; c<=c2; ++c)
            {
                String cell = r.toString() + getChar(c);
                System.out.printf("+++ adding cell location to ship [%s]\n", cell);
                location.add(cell);
            }
        }
    }

    public boolean hit(String cell) {
        boolean damaged = location.remove(cell);
        if (damaged) hit = true;
        return damaged;
    }

    public boolean isSunk() {
        return location.isEmpty();
    }

    public boolean isHit() {
        return hit;
    }

    public Set<String> getLocation() {
        return location;
    }

    private Integer findChar(char x) {
        Integer pos = 0;
        for (char c : letters) {
            if (c == x) break;
            ++pos;
        }
        return pos;
    }

    private char getChar(Integer pos) {
        return letters[pos];
    }

    private Ship() {}

    private Set<String> location = new HashSet<>();
    private boolean hit = false;
}
