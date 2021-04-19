package com.leetcode.qa_56;

public class QuickSort {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int pivot(int[] arr, int left, int right) {
        int data = arr[right];
        int swapIndex = left;
        for(int i = left; i < right; i++) {
            if (arr[i] < data) {
                swap(arr, i, swapIndex);
                swapIndex++;
            }
        }
        swap(arr, right, swapIndex);
        return swapIndex;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = pivot(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 1, 6, 8, 9, 0, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
