import java.util.Scanner;

/**
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 */
public class test07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int AsubB = scanner.nextInt();
        int BsubC = scanner.nextInt();
        int AaddB = scanner.nextInt();
        int BaddC = scanner.nextInt();
        int b_2 = BaddC + BsubC;
        if (b_2 % 2 == 1) {
            System.out.println("No");
            return;
        }
        int B = b_2 / 2;
        int C = BaddC - B;
        int A = AsubB + B;
        if (((A - B) == AsubB) &&
                ((B - C) == BsubC) &&
                ((A + B) == AaddB) &&
                ((B + C) == BaddC)) {
            if (A > 0 && B > 0 && C > 0) {
                System.out.println(A + " " + B + " " + C);
            }
        } else {
            System.out.println("No");
        }
    }
}
