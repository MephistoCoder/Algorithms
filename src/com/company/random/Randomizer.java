package com.company.random;

import java.util.Random;

public abstract class Randomizer {
    static final int[] LENGTHS = {10, 100, 1000, 10000};
    public static void init(int[][][] array){
        Random random = new Random();
        for (int i = 0; i < 4; i++ ){
            for (int j = 0; j < 3; j++){
                array[i][j] = new int [LENGTHS[i]];
                for (int k = 0, t = LENGTHS[i]; k < LENGTHS[i]; k++, t--) {
                    if (j == 0)
                        array[i][j][k] = random.nextInt(LENGTHS[i]) + 1;
                    else if (j == 1)
                        array[i][j][k] = k;
                    else
                        array[i][j][k] = t;
                }
            }
        }

    }
}
