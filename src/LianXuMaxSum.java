import java.util.Scanner;

/**
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 */
public class LianXuMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Long[][] arr = new Long[number][number];
        int[] arrays = new int[number];
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            arrays[i] = n;
            arr[i][i] = Long.valueOf(n);
        }
        //方法1：二维数组 一人一个oom
        Long sum = new Long(arrays[0]);
        //初始化二维数组
        for (int i = 0; i < number; i++) {
            if (arr[i][i] > sum) {
                sum = arr[i][i];
            }
            for (int j = i + 1; j < number; j++) {
                arr[i][j] = arr[i][j - 1] + arrays[j];
                if (arr[i][j] > sum) {
                    sum = arr[i][j];
                }
            }
        }
        //方法2：动态规划 以i为结尾的连续子串的最大值
        //dp[i]=Math.max(dp[i-1],0)
        Long[] list = new Long[number];
        list[0] = Long.valueOf(arrays[0]);
        Long mix = 0L + arrays[0];
        for (int i = 1; i < number; i++) {
            if (list[i - 1] < 0) {
                list[i] = arrays[i] + 0l;
            } else {
                list[i] = list[i - 1] + arrays[i];
            }
            if (mix < list[i]) {
                mix = list[i];
            }
        }
        System.out.println(sum);
        System.out.println(mix);
    }
}
