/**
 * @author zhanyuhao
 * @time 2021/3/19 9:45
 */
package array;

import java.util.Arrays;

public class L3_滑动窗口 {

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq, 0);
        int l = 0, r = 0;
        int res = -1;
        while (l <= s.length() - 1) {
            if (r < s.length() && freq[s.charAt(r)] == 0) {
                res = Math.max(res, r - l + 1);
                freq[s.charAt(r)]++;
                r++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        if (res == -1)
            return 0;
        return res;
    }
}
