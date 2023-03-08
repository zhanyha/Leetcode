/**
 * @author zhanyuhao
 * @time 2021/3/2 10:39
 */
package array;

import util.ArrayUtil;

public class 奇数在左 {
    public static void leftAndRight(int[] arr){
        int l = 0, r = arr.length - 1;
        while(l != r){
            while(l < r && arr[l] % 2 != 0){
                l++;
            }
            while(l < r &&arr[r] % 2 != 1){
                r--;
            }
            if(l < r)
                swap(arr,l,r);
        }
    }
    private static void swap(int[] arr, int l , int r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArray(10);
        leftAndRight(arr);
        ArrayUtil.print(arr);
    }
}
