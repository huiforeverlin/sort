package com.myself.sort;


//直接插入排序
public class InsertSort {
    private int[] arr;
    private int len;

    public InsertSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    public void insert() {
        int i, j;
        for (i = 1; i < len; i++) {//从数组第二个元素开始遍历数组（数组首元素已经有序）
            int key = arr[i];//由于可能会将arr[i]之前的数顺序后移，此过程定会覆盖原来的arr[i]，所以一定要在挪动元素之前把arr[i]保存起来
            for (j = i - 1; j >= 0; j--) {
                if (key > arr[j]) {//往前遍历的时候第一次遇到比key小的元素时就可以停下了
                    break;
                }
                arr[j + 1] = arr[j];//否则将key之前的元素顺序后移
            }
            arr[j + 1] = key;//将key插到相应位置
        }
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
