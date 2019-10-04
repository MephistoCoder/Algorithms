package com.company.sorts;

import java.util.Arrays;

public class MergeSort extends Sort{
    @Override
    public void doSort(int[] array){
        long start = System.currentTimeMillis();
        time = 0;
        moves = 0;
        evaluates = 0;
        sort(array, 0, array.length - 1);
        time = System.currentTimeMillis() - start;
    }
    public void sort(int[] array, int low, int high) {

        if (high <= low){
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);

        int[] buf = Arrays.copyOf(array, array.length);

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            moves++;
            evaluates++;
            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > high) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
    }
}