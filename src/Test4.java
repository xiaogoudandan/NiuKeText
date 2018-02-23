import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 输入描述:
 * 输入为两行:
 * 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 * 第二行为n个正整数A[i](32位整数)，以空格隔开。
 */
public class Test4 {
    public static void main(String[] args) {
        long dp[] = new long[1000 + 1];
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = scanner.nextInt();
        int a[] = new int[number];
        for (int i = 0; i < number; i++) {
            a[i] = scanner.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < number; i++) {
            for (int j = sum; j >=a[i]; j--) {
                dp[j] = dp[j] + dp[j - a[i]];
            }
        }

        System.out.println(dp[sum]);
    }
}
