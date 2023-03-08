/**
 * @author zhanyuhao
 * @time 2021/2/23 16:05
 */
package bit;

//https://leetcode-cn.com/problems/number-of-1-bits/
public class P_191 {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(9));
    }
}

class Solution {

    private int count;

    public int hammingWeight(int n) {

        return method(n);
    }

    private int method(int n) {
        count = 0;
        while(n != 0){
            count++;
            n = n & n-1;
        }
        return count;
    }
}

class Solution1 {

    public int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
