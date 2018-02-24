import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 */
public class test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int a = 0;
        int b = 0;
        for (int i = 2; i <= number; i++) {
            a += find2or5(i, 2);
            b += find2or5(i, 5);
        }
        System.out.println(Math.min(a, b));
    }

    private static int find2or5(int i, int m) {
        int sum = 0;
        while (i != 0 && i % m == 0) {
            i = i / m;
            sum++;
        }
        return sum;
    }
}
