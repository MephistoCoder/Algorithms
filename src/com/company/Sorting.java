package com.company;

import com.company.sorts.*;

import java.io.FileWriter;
import java.io.IOException;

public class Sorting{
    private int[][][] array;

    private FileWriter fileWriter;
    private FileWriter fileTest;

    private HeapSort heapSort;
    private InsertionSort insertionSort;
    private MergeSort mergeSort;
    private QuickSort quickSort;

    Sorting(int [][][] array) throws IOException {
        this.array = array;

        this.heapSort = new HeapSort();
        this.insertionSort = new InsertionSort();
        this.mergeSort = new MergeSort();
        this.quickSort = new QuickSort();

        this.fileWriter = new FileWriter("./res/output.txt", false);
        this.fileTest = new FileWriter("./res/test.txt", false);
    }
    private void write(int ... length) throws IOException{
        if (length.length == 0)
            fileWriter.write("Результаты сортировок: \n\n");
        else if (length[0] == 0)
            fileWriter.write("Массив случайных чисел длинной в " + length[1]+ ":\n");
        else if (length[0] == 1)
            fileWriter.write("Массив возрастающих чисел длинной в " + length[1]+ ":\n");
        else if (length[0] == 2)
            fileWriter.write("Массив спадающих чисел длинной в " + length[1]+ ":\n");

    }
    private void writeTest(int arr[], boolean separator) throws IOException{
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i] + " ");
        }
        if (separator)
            str.append("\n**************");
        str.append("\n");
        fileTest.write(str.toString());
        fileTest.flush();
    }
    private void writeResult(Sort sort) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sort.getClass()).append(": ").append("\nПерестановок: ").append(sort.getMoves());
        stringBuilder.append("\nСравнений: ").append(sort.getEvaluates());
        stringBuilder.append("\nВремя выполнения: ").append(sort.getTime()).append("\n\n");
        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();
    }
    public void doSort()throws IOException{
        write();
        int arr[];
        for (int i = 0; i < 4; i++ ){
            for (int j = 0; j < 3; j++){
                write(j, array[i][j].length);

                arr = array[i][j].clone();
                writeTest(arr, true);
                heapSort.doSort(arr);
                writeResult(heapSort);
                writeTest(arr, false);

                arr = array[i][j].clone();
                insertionSort.doSort(arr);
                writeResult(insertionSort);
                writeTest(arr, false);

                arr = array[i][j].clone();
                mergeSort.doSort(arr);
                writeResult(mergeSort);
                writeTest(arr, false);

                arr = array[i][j].clone();
                quickSort.doSort(arr);
                writeResult(quickSort);
                writeTest(arr, true);
            }
        }
    }
}