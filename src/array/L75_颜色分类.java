/**
 * @author zhanyuhao
 * @time 2021/3/19 8:36
 */
package array;

import util.ArrayUtil;

public class L75_颜色分类 {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int l, int r) {
        int zero = l, two = r;
        int i = l;
        while (i <= two) {
            if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            } else if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else
                i++;
        }

    }

    private void swap(int[] nums, int i, int two) {
        int t = nums[i];
        nums[i] = nums[two];
        nums[two] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new L75_颜色分类().sortColors(nums);
        ArrayUtil.print(nums);
    }
}
