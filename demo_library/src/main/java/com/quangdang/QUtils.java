package com.quangdang;

public class QUtils {
    public static void main(String[] args) {
        System.out.println("HELLO TAU CHẠY NÈ");
        int[] arr = {3, 4, 5};
        QUtils.printArray(arr);


    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
