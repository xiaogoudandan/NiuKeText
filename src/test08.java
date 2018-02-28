import java.util.Scanner;

/**
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，
 * 只提供6个每袋和8个每袋的包装(包装不可拆分)。 可是小易现在只想购买恰好n个苹果，
 * 小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 */
public class test08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 100;
        for (int i = 0; i < 20; i++) {
            if (i * 6 > 100)
                break;
            int a = number - i * 6;
            if (a % 8 == 0) {
                int n = a / 8 + i;
                if (sum > n) {
                    sum = n;
                }
            }
        }
        if (sum == 100) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
        }
    }
}
