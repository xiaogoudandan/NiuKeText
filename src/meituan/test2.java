package meituan;

import java.util.Scanner;

/**
 * 在十进制表示中，任意一个正整数都可以用字符‘0’-‘9’表示出来。但是当‘0’-‘9’这些字符每种字符的数量有限时，可能有些正整数就无法表示出来了。比如你有两个‘1’ ，一个‘2’ ，那么你能表示出 11，12，121 等等，但是无法表示出 10，122，200 等数。

 现在你手上拥有一些字符，它们都是‘0’-‘9’的字符。你可以选出其中一些字符然后将它们组合成一个数字，那么你所无法组成的最小的正整数是多少？

 输入
 第一行包含一个由字符’0’-‘9’组成的字符串，表示你可以使用的字符。

 · 1 ≤字符串长度≤ 1000

 输出
 输出你所无法组成的最小正整数。


 样例输入
 55

 样例输出
 1


 Hint
 Input Sample 2
 123456789
 Output Sample 2
 10
 */

/**
 *


 import java.util.Scanner;

 public class Main {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 String S = scanner.nextLine();
 String T = scanner.nextLine();
 int number = S.length() - T.length() + 1;
 StringBuffer s = new StringBuffer(S);
 StringBuffer t = new StringBuffer(T);
 int sun = 0;
 for (int i = 0; i < number; i++) {
 for (int j = 0; j < T.length(); j++) {
 if (s.charAt(j + i) != t.charAt(j)) {
 sun++;
 }
 }
 }
 System.out.println(sun);
 }
 }
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[10];
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            int n = (a - '0');
            array[n]++;
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[min] > array[i]) {
                min = i;
            }
        }
        int min2 = 0;
        if(min==min2){
            min2++;
        }
        for (int i = min2+1; i < array.length; i++) {
            if (min2 != min && array[min2] > array[i]) {
                min2 = i;
            }
        }
        int num = array[min];
        int num2 = array[min2];
        StringBuffer stringBuffer = new StringBuffer();
        if (min == 0) {
            if (num2 == num) {
                for (int i = 0; i < num; i++) {
                    stringBuffer.append(min2);
                }
                stringBuffer.append(min2);
            } else {
                stringBuffer.append("1");
                for (int i = 0; i < array[min]; i++) {
                    stringBuffer.append("0");
                }
                stringBuffer.append("0");
            }
        } else {
            for (int i = 0; i < num; i++) {
                stringBuffer.append(min);
            }
            stringBuffer.append(min);
        }
        System.out.println(stringBuffer.toString());
        boolean is = false;
        int i = 1;
        while (true) {
            int[] clone = array.clone();
            String s1 = Integer.toString(i);
            for (int j = 0; j < s1.length(); j++) {
                int number = (s1.charAt(j) - '0');
                if (clone[number] == 0) {
                    is = true;
                    break;
                } else {
                    clone[number]--;
                }
            }
            if (is) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
