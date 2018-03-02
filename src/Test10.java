import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
 * BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
 * AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 * 你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
 * 主要是两种情况：
 * 1、最后个数字相同
 * 2、最后两个数字不相同
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            long[] dp = new long[31];
            dp[1] = 3;
            dp[2] = 9;
            dp[3] = 21;
            for (int i = 4; i < a + 1; i++) {
                dp[i] = 2 * dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[a]);
        }
    }
}
