import java.util.Scanner;
import java.util.Stack;

/**
 * 请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
 */
public class IntagerAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        if (s[0].length() < s[1].length()) {
            add(s[0], s[1]);
        } else {
            add(s[1], s[0]);
        }
    }

    /**
     * 长数相加   s的长度小于 s1
     *
     * @param s
     * @param s1
     */
    private static void add(String s, String s1) {
        Stack<Integer> stack = new Stack<>();
        int a_length = s.length();
        int b_length = s1.length();
        int c = 0;//溢出值
        int i = 0;
        for (; i < s.length(); i++) {
            //获取到两个数
            char a = s.charAt(a_length - 1 - i);
            char b = s1.charAt(b_length - 1 - i);
            //取到当前两个值
            int x = a - '0';
            int y = b - '0';
            if (x > 9 || y > 9) {//异常
                System.out.println("Error");
                return;
            }
            if (x + y + c > 9) {
                stack.push((x + y + c) % 10);
                c = 1;
            } else {
                stack.push((x + y + c) % 10);
                c = 0;
            }
        }

        for (; i < b_length; i++) {
            char b = s1.charAt(b_length - 1 - i);
            int y = b - '0';
            if (y > 9) {//异常
                System.out.println("Error");
                return;
            }
            if(y + c > 9) {
                stack.push((y + c) % 10);
                c = 1;
            } else {
                stack.push((y + c) % 10);
                c = 0;
            }
        }
        if(c==1){
            stack.push(1);
        }
        while (!stack.isEmpty()){
            int a=stack.pop();
            System.out.print(a);
        }
    }
}
