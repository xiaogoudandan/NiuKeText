package meituan;

import java.util.Scanner;

/**
 * 给出两个相同长度的由字符 a 和 b 构成的字符串，定义它们的距离为对应位置不同的字符的数量。如串”aab”与串”aba”的距离为 2；串”ba”与串”aa”的距离为 1；串”baa”和串”baa”的距离为 0。下面给出两个字符串 S 与 T，其中 S 的长度不小于 T 的长度。我们用|S|代表 S 的长度，|T|代表 T 的长度，那么在 S 中一共有|S|-|T|+1 个与 T 长度相同的子串，现在你需要计算 T 串与这些|S|-|T|+1 个子串的距离的和。
 * <p>
 * 输入
 * 第一行包含一个字符串 S。
 * <p>
 * 第二行包含一个字符串 T。
 * <p>
 * S 和 T 均由字符 a 和 b 组成，1 ≤ |T| ≤ |S| ≤105 。
 * <p>
 * 输出
 * 输出对应的答案。
 * <p>
 * <p>
 * 样例输入
 * aab
 * <p>
 * aba
 * <p>
 * 样例输出
 * 2
 * <p>
 * <p>
 * Hint
 * Input Sample 2
 * aaabb
 * bab
 * Output Sample 2
 * 5
 * 在样例 2 中，”aaa”与”bab”的距离为 2，”aab”与”bab”的距离为 1，”abb”与”bab”的距离为 2，
 * 所以最后答案为 5。
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        int number = S.length() - T.length() + 1;
        StringBuffer s = new StringBuffer(S);
        char[] arrays = new char[100000];
        for (int i = 0; i < S.length(); i++) {
            arrays[i] = S.charAt(i);
        }
        StringBuffer t = new StringBuffer(T);
        int sun = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < T.length(); j++) {
                if (arrays[i + j] != t.charAt(j)) {
                    sun++;
                }
            }
        }
        System.out.println(sun);
    }
}




//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String S = scanner.nextLine();
//        String T = scanner.nextLine();
//        int number = S.length() - T.length() + 1;
//        StringBuffer s = new StringBuffer(S);
//        StringBuffer t = new StringBuffer(T);
//        int sun = 0;
//        for (int i = 0; i < number; i++) {
//            for (int j = 0; j < T.length(); j++) {
//                if (s.charAt(j + i) != t.charAt(j)) {
//                    sun++;
//                }
//            }
//        }
//        System.out.println(sun);
//    }
//}