import java.util.Scanner;

/**
 * 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
 */
public class yihuo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[number];
        int sum = 0;
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                if ((array[i] ^ array[j]) > m) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
