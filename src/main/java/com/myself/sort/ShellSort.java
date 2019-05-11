package com.myself.sort;

public class ShellSort {
    private int[] arr;
    private int len;

    public ShellSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    public void shell() {
        int gap = len;
        while (true) {
            gap = gap / 3 + 1;//间隔，增量
            _shell(gap);
            if (gap == 1) {
                return;
            }
        }
    }

    private void _shell(int gap) {
        int i, j;
        for (i = gap; i >= len; i++) {
            int key = arr[i];
            for (j = i - gap; j >= 0; j -= gap) {
                if (key > arr[j]) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = key;
        }
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
