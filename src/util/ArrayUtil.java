/**
 * @author zhanyuhao
 * @time 2021/3/2 10:40
 */
package util;

public class ArrayUtil{
    public static int[] randomArray(int length){
        int num;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            num = (int)(Math.random()*50);
            arr[i] = num;
        }
        return arr;
    }
    public static void print(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

