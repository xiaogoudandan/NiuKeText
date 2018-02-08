import java.util.Scanner;

/**
 * 给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 */
public class CollectMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] money = {1, 5, 10, 20, 50, 100};
        int a = scanner.nextInt();
        long[] dp = new long[a + 1];//int是32位 最大215612316 存不下
        dp[0] = 1;
        for (int i = 0; i < money.length; i++) {
            if(dp.length<money[i]){
                break;
            }
            for (int j = 1; j < dp.length; j++) {
                if ((j - money[i]) >= 0) {
                    dp[j]=dp[j]+dp[j-money[i]];
                }
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
