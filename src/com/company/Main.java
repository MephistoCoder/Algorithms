package com.company;

import com.company.random.Randomizer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int[][][] arrays = new int[4][3][];
        Randomizer.init(arrays);
        try {
            Sorting sorting = new Sorting(arrays);
            sorting.doSort();
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
