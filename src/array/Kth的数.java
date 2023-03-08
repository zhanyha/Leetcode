/**
 * @author zhanyuhao
 * @time 2021/3/2 12:56
 */
package array;

import util.ArrayUtil;

import java.util.Arrays;

public class Kth的数 {
    public static int findK(int[] arr, int k) {
        if (k > arr.length || k <= 0) return 0;
        return findKMethod(arr, 0, arr.length - 1, k);
    }

    private static int findKMethod(int[] arr, int l, int r, int k) {
        int pos = partition(arr, l, r);
        if (pos == k)
            return pos;
        if (pos < k)
            return findKMethod(arr, pos + 1, r,k);
        else
            return findKMethod(arr, l, pos - 1,k);
    }

//    private static void quickSort(int[] arr,int l,int r){
//        if(l < r){
//            int pos = partition(arr,l,r);
//            quickSort(arr,l,pos - 1);
//            quickSort(arr,pos+1,r);
//        }
//    }
    private static int partition(int[] arr, int l, int r) {
        int i = l + 1 , j = r;
        while(i <= j){
            while (i <= j && arr[i] < arr[l])
                i++;
            while (i <= j && arr[j] > arr[l])
                j--;
            if(i < j)
                swap(arr, i, j);
        }
        swap(arr,j,l);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10);
        int num = findK(arr, 4);
        Arrays.sort(arr);
        ArrayUtil.print(arr);
        System.out.println(arr[num]);
        ArrayUtil.print(arr);
    }
}
