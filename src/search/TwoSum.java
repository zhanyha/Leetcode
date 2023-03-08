/**
 * @author zhanyuhao
 * @time 2021/3/20 9:48
 */
package search;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int[] res = new int[]{i, map.get(complement)};
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
