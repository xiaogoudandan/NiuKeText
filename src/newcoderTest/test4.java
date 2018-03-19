package newcoderTest;

import java.util.Scanner;

/**
 * 妞妞参加了Nowcoder Girl女生编程挑战赛, 但是很遗憾, 她没能得到她最喜欢的黑天鹅水晶项链。
 * 于是妞妞决定自己来制作一条美丽的项链。一条美丽的项链需要满足以下条件:
 * 1、需要使用n种特定的水晶宝珠
 * 2、第i种水晶宝珠的数量不能少于li颗, 也不能多于ri颗
 * 3、一条美丽的项链由m颗宝珠组成
 * 妞妞意识到满足条件的项链种数可能会很多, 所以希望你来帮助她计算一共有多少种制作美丽的项链的方案。
 * <p>
 * 输入描述:
 * 输入包括n+1行, 第一行包括两个正整数(1 <= n <= 20, 1 <= m <= 100), 表示水晶宝珠的种数和一条美丽的项链需要的水晶宝珠的数量。
 * 接下来的n行, 每行两个整数li, ri(0 <= li <= ri <= 10), 表示第i种宝珠的数量限制区间。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数, 表示满足限定条件的方案数。保证答案在64位整数范围内。
 * <p>
 * 输入例子1:
 * 3 5
 * 0 3
 * 0 3
 * 0 3
 * <p>
 * 输出例子1:
 * 12
 */
public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int types = scanner.nextInt();
        int number = scanner.nextInt();
        int[] weight = new int[types];
        for (int i = 0; i < types; i++) {//  a到b  转化为  0到（a-b）
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a != 0) {
                weight[i] = b - a;
                number = number - a;
            } else {
                weight[i] = b;
            }
        }
        long[][] dp = new long[20][101];
        for (int i = 0; i <= weight[0]; i++) {//初始化
            dp[0][i] = 1;
        }
        for (int i = 1; i < types; i++) {//遍历宝石种类
            for (int j = 0; j <= weight[i]; j++) {//遍历当前种类宝石的数量
                for (int k = 0; k <= number - j; k++) {
                    dp[i][k + j] += dp[i - 1][k];
                }
            }
        }
        System.out.println(dp[types - 1][number]);
    }
}
