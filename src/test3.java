import java.util.Scanner;

/**
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = s.replaceAll("[A-Za-z]+", " ");
        String a[] = s1.split(" ");
        int sum = 0;
        int number = 0;
        for (int i = 0; i < a.length; i++) {
            int n = a[i].length();
            if (n > sum) {
                sum = n;
                number = i;
            }
        }
        System.out.println(a[number]);
    }
}
