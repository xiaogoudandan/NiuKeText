import java.util.Scanner;
import java.util.Stack;

/**
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 * 如果 X = 123，则rev(X) = 321;
 * 如果 X = 100，则rev(X) = 1.
 * 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 */
public class RevNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        String rev_a = rev(a);
        String rev_b = rev(b);
        int ab = Integer.valueOf(rev_a) + Integer.valueOf(rev_b);
        System.out.println(rev(Integer.toString(ab)));
    }

    public static String rev(String a) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            stack.push(a.charAt(i) + "");
        }
        boolean frist = true;
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            String t = stack.pop();
            if (frist) {//判断最后的几个0
                if (t.equals("0"))
                    continue;
                else {
                    frist = false;
                    stringBuffer.append(t);
                }
            } else {
                stringBuffer.append(t);
            }
        }
        return stringBuffer.toString();
    }
}
