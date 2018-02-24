import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 */
public class test5 {
    static String str[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        int m = scanner.nextInt();
        String number = change(n, m);
        System.out.println(number);
    }

    private static String change(Long n, int m) {
        boolean isZheng = true;
        Long k;
        if (n < 0) {
            k = -n;
            isZheng = false;
        } else {
            k = n;
            isZheng = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Stack<String> stack = new Stack<>();

        while (k / m != 0) {
            stack.push(str[(int) (k % m)]);
            k = k / m;
        }
        stack.push(str[(int) (k % m)]);
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        if (isZheng)
            return stringBuffer.toString();
        else
            return "-" + stringBuffer.toString();
    }
}
