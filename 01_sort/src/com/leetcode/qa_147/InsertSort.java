package com.leetcode.qa_147;

public class InsertSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > data) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 1, 6, 8, 9, 0, 4};
        sort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
