package com.myself.sort;

public class SelectSort {
    private int[] arr;
    private int len;

    public SelectSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    //选择排序
    //时间复杂度：O（n^2）
    public void selectSort() {
        int minSpace = 0;//存放最小值的初始位置
        int maxSpace = len - 1;//存放最大值的初始位置
        while (minSpace < maxSpace) {
            int minPos = minSpace;//排序前先将该区间的第一个数当做最小值
            int maxPos = minSpace;//排序前先将该区间的第一个数当做最大值
            for (int i = minSpace + 1; i <= maxSpace; i++) {
                if (arr[i] < arr[minPos]) {
                    minPos = i;
                }
                if (arr[i] > arr[maxPos]) {
                    maxPos = i;
                }
            }
            swap(minPos, minSpace);//交换最小值和存放最小值位置的值
            if (maxPos == minSpace) {//如果此时最大值恰好在存放最小值的位置时，经过上一步，将会将最大值交换到最小值所在位置，所以更新最大值所在下标为最小值所在下标
                maxPos = minPos;
            }
            swap(maxPos, maxSpace);
            minSpace++;
            maxSpace--;
        }
    }

    //交换两个元素的值
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
