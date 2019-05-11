package com.myself.sort;

import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = scanner.nextInt();
            }
            //冒泡排序
            BubbleSort sortArr = new BubbleSort(arr);
            sortArr.bubbleSort();
            sortArr.print();

            //快速排序
            QuickSort quickSort = new QuickSort(arr);
            quickSort.quickSort();
            quickSort.print();

            //选择排序
            SelectSort selectSort = new SelectSort(arr);
            selectSort.selectSort();
            selectSort.print();

            //堆排序
            HeapSort heapSort = new HeapSort(arr);
            heapSort.heapSort();
            heapSort.print();

            //插入排序
            InsertSort insert = new InsertSort(arr);
            insert.insert();
            insert.print();

            //希尔排序
            ShellSort shellSort = new ShellSort(arr);
            shellSort.shell();
            shellSort.print();

            //归并排序
            MergeSort mergeSort = new MergeSort(arr);
            mergeSort.mergeSort();
            mergeSort.print();
        }
    }
}
