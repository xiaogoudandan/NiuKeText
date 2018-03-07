import java.util.Scanner;

/**
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 */
public class test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int radius = (int) Math.sqrt(n);
        int number1 = 0;
        for (int i = 1; i <= radius; i++) {
            int y = (int) Math.sqrt(n - i * i);
            if (y * y + i * i == n) {
                number1++;
            }
        }

        System.out.println(number1*4);

    }
}
