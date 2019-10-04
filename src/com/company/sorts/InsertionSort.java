package com.company.sorts;

public class InsertionSort extends Sort{
    @Override
    public void doSort(int[] array){
        time = 0;
        long start = System.currentTimeMillis();
        moves = 0;
        evaluates = 0;
        sort(array);
        time = System.currentTimeMillis() - start;
    }
    public void sort(int[] array)
    {
        int key;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            int j = i - 1;
            moves++;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                moves++;
            }
            array[j + 1] = key;
            moves++;
        }
    }
}
