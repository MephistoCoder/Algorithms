package com.company.sorts;

public class QuickSort extends Sort{
    @Override
    public void doSort(int[] array){
        time = 0;
        long start = System.currentTimeMillis();
        moves = 0;
        evaluates = 0;
        sort(array, 0, array.length - 1);
        time = System.currentTimeMillis() - start;
    }
    public  void sort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high) {
            return;//завершить выполнение если уже нечего делить
        }
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                evaluates++;
                i++;
            }

            while (array[j] > opora) {
                evaluates++;
                j--;
            }

            if (i <= j) {//меняем местами
                evaluates++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                moves += 3;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            sort(array, low, j);

        if (high > i)
            sort(array, i, high);
    }
}