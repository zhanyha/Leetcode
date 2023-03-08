/**
 * @author zhanyuhao
 * @time 2021/2/23 16:27
 */
package bit;

public class 二进制的奇偶位互换 {
    public static void main(String[] args) {
        int res = solution(9);
        System.out.println(Integer.toBinaryString(res));

    }
    private static int solution(int n){
        int y = n & 0xccccccc;//101010101010101010... 保留了偶数位置的1
        int z = n & 0x5555555;//010101010101010101.。。 保留了奇数位置上的1
        y = y>>1;//左移一位
        int res = y ^ z;//再次异或运算即可
        return res;
    }
}

