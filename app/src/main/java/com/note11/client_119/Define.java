package com.note11.client_119;

public class Define {

    public double get_distance = 0;
    public double plongitude = 0;
    public double platitude = 0;

    private static Define instance;
    public static Define ins() {
        if (instance == null) {
            instance = new Define();
        }

        return instance;

    }
}
