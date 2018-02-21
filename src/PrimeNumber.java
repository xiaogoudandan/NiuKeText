import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number % 2 > 0) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 3; i <= number; i++) {
            if (
                    (i / 2) > 1 && (i % 2 == 0)
                            || (i / 3) > 1 && (i % 3 == 0)
                            || (i / 5) > 1 && (i % 5 == 0)
                            || (i / 7) > 1 && (i % 7 == 0)
                            || (i / 11) > 1 && (i % 11 == 0)
                            || (i / 13) > 1 && (i % 13 == 0)
                            || (i / 17) > 1 && (i % 17 == 0)
                            || (i / 23) > 1 && (i % 23 == 0)
                            || (i / 29) > 1 && (i % 29 == 0)
                    ) {
                continue;
            } else {
                if (isPrime(i)) {
                    list.add(i);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (n <= number / 2) {
                if (list.contains(number - n)) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 判断是否是质数
     *
     * @param i
     * @return
     */
    private static boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        int m = (int) Math.sqrt(i);
        int count = 0;
        for (int j = 2; j <= m; j++) {
            if (i % j == 0) {
                if (++count > 0) {
                    break;
                }
            }
        }
        return count == 0;
    }
}
