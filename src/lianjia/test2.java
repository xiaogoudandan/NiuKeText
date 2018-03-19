package lianjia;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 本题包含若干组测试数据。
 每组测试数据：
 第一行一个整数n，表示有n个人在进行赛跑比赛。
 满足 1<=n<=1000
 输出
 输出答案，保留两位小数。
 样例输入
 2
 2
 样例输出
 1.50
 1.50
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int number = scanner.nextInt();
            int ban_ = number - 1;
            int sum = number;
            for (int i = 1; i <number; i++) {
                sum += i * C_m_n(ban_, ban_ - i + 1);
            }
            int sum_b = A_m_n(number, number);
            double gailu = (double) sum / (double) sum_b;
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.println(decimalFormat.format(gailu));
        }
    }

    public static int C_m_n(int n, int m) {
        if (n == m) {
            return 1;
        } else {
            int a = 1;
            for (int i = n; i > n - m; i--) {
                a = a * i;
            }
            int b = 1;
            for (int i = m; i > 0; i--) {
                b = b * i;
            }
            return a / b;
        }
    }

    public static int A_m_n(int n, int m) {
        if (n >= m) {
            int a = 1;
            for (int i = n; i > n - m; i--) {
                a = a * i;
            }
            return a;
        }
        return 0;
    }
}
