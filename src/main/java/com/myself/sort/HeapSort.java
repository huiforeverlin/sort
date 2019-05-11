package com.myself.sort;

public class HeapSort {
    private int[] arr;
    private int len;

    public HeapSort(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    //堆排序
    //时间复杂度：O（nlgn）
    public void heapSort() {
        //1.从最后一个非叶节点开始做向下调整，直到根节点
        for (int i = (len - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i, len);
        }
        //2.交换根节点的值和最后一个节点的值，对根节点做向下调整，同时让节点个数-1，重复上述过程，直到节点个数为0
        for (int i = 0; i < len; i++) {
            swap(0, len - 1 - i);//交换根节点的值和最后一个节点的值
            adjustDown(0, len - 1 - i);//在节点个数减-的情况下对根节点做向下调整
        }
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void adjustDown(int root, int len) {
        int left = 2 * root + 1;//root所在节点的左孩子节点下标
        int right = 2 * root + 2;//root所在节点的右孩子节点下标
        if (left < len) {//保证左孩子所在节点的下标一定在数组中
            int maxChild = left;//先将左孩子节点值作为左右孩子节点值的较大值
            if (right < len && arr[right] > arr[left]) {//保证右孩子所在节点下标也在数组中，且当右孩子节点值大于左孩子节点值时更新较大值节点下标
                maxChild = right;
            }
            if (arr[root] >= arr[maxChild]) {//比较父节点和较大孩子节点的值，如果父节点值大于等于较大孩子节点值，则对该节点（父节点）的向下调整结束
                return;
            } else {//否则，交换父节点值和较大孩子节点值，并对较大孩子节点做向下调整（保证以父节点为根节点的二叉树满足堆的性质）
                swap(root, maxChild);
                adjustDown(maxChild, len);
            }
        }
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
