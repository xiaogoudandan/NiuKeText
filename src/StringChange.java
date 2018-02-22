import java.util.Scanner;

/**
 * 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
 */
public class StringChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String str[] = a.split(" ");
        int i;
        for (i = str.length - 1; i > 0; i--) {
            System.out.print(str[i] + " ");
        }
        System.out.println(str[i]);
    }
}
