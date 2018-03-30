import java.util.Scanner;

/**
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 * 输入描述:
 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 * 输出描述:
 * 输出一个最多可以放的蛋糕数
 * 示例1
 * 输入
 * <p>
 * 3 2
 * 输出
 * <p>
 * 4
 */
public class test21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int type1 = type1(h);
        int type2 = type2(h);
        if (w % 4 == 0) {
            System.out.println(w / 2 * type1 + w / 2 * type2);
        } else {
            int a = w / 2 + 1;
            int b = w - a;
            System.out.println(a * type1 + b * type2);
        }
    }

    public static int type2(int n) {
        if (n % 4 == 0) {
            return n / 2;
        } else if (n % 2 == 0) {
            return n / 2 - 1;
        } else {
            return n / 2;
        }
    }


    public static int type1(int n) {
        if (n % 4 == 0) {
            return n / 2;
        } else if (n % 2 == 0) {
            return n / 2 + 1;
        } else {
            return n / 2 + 1;
        }
    }


}
