import java.util.Scanner;
import java.util.Stack;

/**
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3，按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 */
public class ScaleChange {
    //10进制转为其他进制，除留取余，逆序排列
    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();

    public static String _10_to_N(long number, int N) {
        Long rest = number;
        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(array[new Long((rest % N)).intValue()]);
            rest = rest / N;
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        return result.length() == 0 ? "0" : result.toString();

    }

    /**
     * 返回N机制的各位数之和
     *
     * @param number
     * @param N
     * @return
     */
    public static int Ten2N(long number, int N) {
        Long rest = number;
        int sum = 0;
        while (rest != 0) {
            sum = sum + (new Long(rest % N).intValue());
            rest = rest / N;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int sum = 0;
            //计算总数
            for (int i = 2; i < n; i++) {
                sum = sum + Ten2N(n, i);
            }
            int m = n - 2;
            boolean is = true;
            while (is) {
                is = false;
                for (int i = 2; i <= m; i++) {
                    if (sum % i == 0 && m % i == 0) {
                        sum = sum / i;
                        m = m / i;
                        is = true;
                    }
                }
            }


            System.out.println(sum + "/" + m);

        }
    }
}
