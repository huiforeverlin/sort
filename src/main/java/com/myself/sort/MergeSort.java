package com.myself.sort;

public class MergeSort {
    private int[] arr;
    private int len;

    public MergeSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    public void mergeSort() {
        _mergeSort(0, len - 1);
    }

    public void _mergeSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            _mergeSort(left, mid);
            _mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int k = 0;
        int low = left;
        int high = mid + 1;
        while (low <= mid && high <= right) {
            if (arr[low] < arr[high]) {
                tmp[k++] = arr[low++];
            } else {
                tmp[k++] = arr[high++];
            }
        }
        while (low <= mid) {
            tmp[k++] = arr[low++];
        }
        while (high <= right) {
            tmp[k++] = arr[high++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
