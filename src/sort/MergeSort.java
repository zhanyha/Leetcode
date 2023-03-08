/**
 * @author zhanyuhao
 * @time 2021/2/23 17:37
 */
package sort;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = Arrays.copyOf(arr, arr.length);

        int i = left, j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = tmp[j++];
            } else if (j > right) {
                arr[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j])
                arr[k] = tmp[i++];
            else
                arr[k] = tmp[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 7, 4};
        mergeSort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
