/**
 * @author zhanyuhao
 * @time 2021/3/19 9:53
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class L438_滑动窗口 {
    //s: "cbaebabacd" p: "abc"
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0, r = l + p.length();
        List<Integer> res = new ArrayList<>();
        while (l <= s.length() - p.length()) {
            String s1 = s.substring(l, r);
            boolean flag = isAnagrams(s1, p);
            if (flag) {
                res.add(l);
            }
            l++;
            r = l + p.length();
        }
        return res;
    }

    private boolean isAnagrams(String s1, String p) {
        int[] freq = new int[256];
        for (int i = 0; i < p.length(); i++)
            freq[p.charAt(i)]++;
        for (int i = 0; i < s1.length(); i++)
            if (freq[s1.charAt(i)] == 0)
                return false;
            else
                freq[s1.charAt(i)]--;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L438_滑动窗口().findAnagrams("cbaebabacd", "abc"));
    }
}
