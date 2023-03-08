/**
 * @author zhanyuhao
 * @time 2021/2/23 17:23
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class 汉诺塔问题 {
    private static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        hanota2(n,A,B,C);
        System.out.println(C);
    }

    private static void hanota2(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if(n == 1)
            c.add(a.remove(0));
        hanota2(n-1,a,c,b);
        c.add(a.remove(0));
        hanota2(n-1,b,a,c);
    }

}

