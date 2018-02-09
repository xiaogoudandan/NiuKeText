import java.util.Scanner;

/**
 * 题目描述
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 */
public class WalkGridding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] dp = new int[a + 1][b + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= a; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= b; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[a][b]);
    }
}
