package com.myself.sort;

import java.util.Scanner;

public class BubbleSort {
    private int[] arr;
    private int len;


    public BubbleSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }


    public void bubbleSort() {
        for (int i = len - 1; i > 0; i--) {//len个元素，总共进行len-1趟排序
            boolean flag = false;//标识此趟排序是否有元素交换了位置，flag为false表示没交换
            for (int j = 0; j < i; j++) {//每进行完一趟排序，将要排序的区间缩小1个元素
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    flag = true;//有元素交换，flag置为true
                }
            }
            //如果一趟排序下来flag一直为false，表明此趟排序没有元素交换位置，说明此时数组已经有序，可结束排序
            if (flag == false) {
                return;
            }
        }
    }

    public void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
