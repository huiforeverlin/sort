package com.myself.sort;

public class QuickSort {
    private int[] arr;
    private int len;

    public QuickSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    public void quickSort() {
        __quickSort(0, len - 1);
    }

    private void __quickSort(int left, int right) {
        if (left == right) {//区间只剩一个元素的情况下不用再进行排序
            return;
        }
        if (left > right) {//区间没有元素了
            return;
        }
        int div = parition3(left, right);
        __quickSort(left, div - 1);
        __quickSort(div + 1, right);
    }
//以下三种方法均以区间最后一个元素作为基准值

    //1. 左右指针法
    private int parition1(int left, int right) {
        int begin = left;
        int end = right;
        while (begin < end) {
            while ((begin < end) && (arr[begin] <= arr[right])) {//此步的begin<end一定要写，因为如果区间本身已经有序，begin会一直往右走，直到走到end，还会继续往右走
                begin++;
            }
            //此时begin所指向的元素比基准值大
            while ((begin < end) && (arr[end] >= arr[right])) {//同理，此步的begin<end也一定要写
                end--;
            }
            //此时end所指向的元素比基准值小
            swap(begin, end);//交换begin和end所指向的元素
        }
        swap(begin,right);
        return begin;
    }

    //2. 挖坑法
    private int parition2(int left, int right) {
        int key = arr[right];//记录基准值
        int begin = left;
        int end = right;
        while (begin < end) {
            while ((begin < end) && (arr[begin] <= key)) {
                begin++;
            }
            //此时begin所指向的值比基准值大
            arr[end] = arr[begin];
            while ((begin < end) && (arr[end] >= key)) {
                end--;
            }
            arr[begin] = arr[end];
        }
        arr[begin] = key;
        return begin;
    }

    //3. 前后指针法
    private int parition3(int left, int right) {
        int div = left;
        int cur;
        for (cur = left; cur < right; cur++) {
            if (arr[cur] <= arr[right]) {//遇到cur指向的值小于等于基准值就交换div和cur指向的值，并让div往右走一步，以保证div之前的值都小于等于基准值
                swap(div, cur);
                div++;
            }
        }
        //此时cur=right
        swap(div, cur);
        return div;
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
