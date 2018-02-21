import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * 题目描述
 * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下：
 * a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy
 * 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，
 * 输出这个编码对应的Index.
 */
public class TrieChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine().trim();
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            int beizhu = c - 'a';
            switch (i) {
                case 0:
                    result += beizhu * (25 * 25 * 25 + 25 * 25 + 25 + 1) + 1;
                    break;
                case 1:
                    result += beizhu * (25 * 25 + 25 + 1) + 1;
                    break;
                case 2:
                    result += beizhu * (25 + 1) + 1;
                    break;
                case 3:
                    result += beizhu * 1 + 1;
                    break;
            }
        }
        System.out.println(result - 1);
    }
}
