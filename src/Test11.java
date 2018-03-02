import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，
 * 小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
 * 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
 * 例如：
 * N = 4，M = 24：
 * 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();//当前
        int target = scanner.nextInt();//目标
        int dp[] = new int[100001];
        for (int i = 0; i < target + 1; i++) {
            dp[i] = Integer.MAX_VALUE;//其余不可达
        }
        dp[position] = 0;//当前位置
        for (int i = position; i < target + 1; i++) {
            int t = dp[i];
            if (t != Integer.MAX_VALUE) {
                ArrayList<Integer> arrayList = Util.getYueNums(i);
                for (Integer integer : arrayList) {
                    if ((integer + i) >= dp.length) {
                        continue;
                    }
                    if (dp[integer + i] == Integer.MAX_VALUE) {//第一次到达
                        dp[integer + i] = dp[i] + 1;
                    } else {
                        if (dp[i] + 1 < dp[integer + i]) {//更小
                            dp[integer + i] = dp[i] + 1;
                        }
                    }
                }
            }
        }
        if (dp[target] != Integer.MAX_VALUE) {
            System.out.println(dp[target]);
        } else {
            System.out.println(-1);
        }
    }
}
