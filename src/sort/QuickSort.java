/**
 * @author zhanyuhao
 * @time 2021/2/24 10:23
 */
package sort;

public class QuickSort {
    public static void quickSort(int[] arr, int l ,int r){
        if(l >= r) return;
        int pos = partition(arr,l,r);
        quickSort(arr,l,pos - 1);
        quickSort(arr,pos+1,r);
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l + 1 , j = r;
        while(i <= j){
            while (i<=j && arr[i] < arr[l])
                i++;
            while (i<=j && arr[j] > arr[l])
                j--;
            if(i < j)
                swap(arr,i,j);
        }
        swap(arr,j, l);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[]arr = {5,3,6,2,1,4,7,8};
        QuickSort.quickSort(arr,0,arr.length - 1);
        for (int v :
                arr) {
            System.out.print(v+" ");
        }
    }
}
