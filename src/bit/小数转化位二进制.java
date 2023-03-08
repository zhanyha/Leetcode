/**
 * @author zhanyuhao
 * @time 2021/2/23 16:37
 */
package bit;

public class 小数转化位二进制 {
    private static String mathToBin(double num){
        StringBuilder sbr = new StringBuilder();
        sbr.append("0.");
        while(num != 0){
            num *= 2;
            if(num >= 1) {
                num -= 1;
                sbr.append("1");
            }else
                sbr.append("0");

            if(sbr.length() > 32)
                return "ERROR";
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        System.out.println(mathToBin(0.625));
        System.out.println(mathToBin(0.25+0.125));
        System.out.println(mathToBin(0.2));
    }
}
