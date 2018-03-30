import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 输出描述:
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * 示例1
 * 输入
 * <p>
 * 4
 * 7 15 9 5
 * 输出
 * <p>
 * 3
 */
public class test22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (int n = 0; n < number; n++) {
            int a = scanner.nextInt();
            sum += a;
            arrayList.add(a);
        }
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int server = 0;
        if (sum % number != 0) {
            System.out.println(-1);
            System.exit(-1);
        } else {
            server = sum / number;
        }
        int n = 0;
        for (int i = 0; i < number; i++) {
            int a = arrayList.get(i);
            if (a > server) {
                int cha = server - a;
                if (cha % 2 != 0) {
                    n = -1;
                    break;
                }
            } else {
                int cha = server - a;
                if (cha % 2 == 0) {
                    n = n + cha / 2;
                } else {
                    n = -1;
                    break;
                }
            }
        }
        if (n == -1) {
            System.out.println(-1);
        } else {
            System.out.println(n);
        }

    }
}
