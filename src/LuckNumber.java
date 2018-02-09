import java.util.Scanner;

/**
 *
 */
public class LuckNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (isLuck(i)) {
                sum++;
            }
        }
        System.out.println(sum);
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
    }

    private static boolean isLuck(int i) {
        String shi = Integer.toString(i);
        String er = Integer.toBinaryString(i);
        if (computer(shi) == computer(er))
            return true;
        return false;
    }

    private static int computer(String shi) {
        int sum = 0;
        for (int i = 0; i < shi.length(); i++) {
            int a = Integer.valueOf(shi.charAt(i) + "");
            sum = sum + a;
        }
        return sum;
    }
}
