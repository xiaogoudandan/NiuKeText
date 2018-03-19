package newcoderTest;

import java.util.Scanner;

/**
 * 美丽的牛家庄受到了外星人的侵略, 勇敢的妞妞要上战场抵御侵略。

 在妞妞上战场前, 村长牛牛给了妞妞N件装备, 妞妞需要选择其中的K件,装备在身上提升自己的战斗力。每件装备有5种属性增幅值,对于第i件装备它的属性增幅值为(ri1, ri2, ri3, ri4, ri5), 分别代表该装备对不同的属性值增幅。
 当妞妞装备多件装备的时候,由于装备之前会互相影响, 对于每种属性值的增幅并不是所有装备该属性值之和, 而是该种属性值下所有装备中最大的属性值。而妞妞最终增加的战斗力为这5种属性值增幅之和。

 妞妞一定要保卫牛家庄, 所以她希望她能提升尽可能多的战斗力, 请你帮帮她计算她最多能增加多少战斗力。

 输入描述:
 输入包括N+1行,
 第一行包括两个正整数N和K(1 <= N <= 10000, 1 <= K <= N), 分别表示一共有的装备数量和妞妞需要选择的装备数量。
 接下来的N行,每行5个整数ri1, ri2, ri3, ri4, ri5 (0 <= ri1, ri2, ri3, ri4, ri5 <= 10000)表示第i件装备的5种属性值增幅。


 输出描述:
 输出一个整数,表示妞妞最多能增加的战斗力。

 输入例子1:
 4 2
 30 30 30 30 0
 50 0 0 0 0
 0 50 0 50 10
 0 0 50 0 20

 输出例子1:
 170

 例子说明1:
 妞妞要从4件装备中选取2件, 如果妞妞选择第1件和第3件装备,那么增加的战斗力为30 + 50 + 30 + 50 + 10 = 170, 这是最大的方案。
 */
public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] r = new int[n][5];
        int result = 0;
        int maxr[] = new int[5];
        for (int i = 0; i < n; i++) {
            r[i] = new int[5];
            for (int j = 0; j < 5; j++) {
                r[i][j] = scanner.nextInt();
                maxr[j] = Math.max(maxr[j], r[i][j]);
            }
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int k = 0; k < 5; k++) {
                    temp += r[i][k];
                }
                result = Math.max(result, temp);
            }
        } else if (m == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = 0;
                    for (int k = 0; k < 5; k++) {
                        temp += Math.max(r[i][k], r[j][k]);
                    }
                    result = Math.max(result, temp);
                }
            }
        } else if (m == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int p = 0; p < n; p++) {
                        int temp = 0;
                        for (int k = 0; k < 5; k++) {
                            temp += Math.max(Math.max(r[i][k], r[j][k]), r[p][k]);
                        }
                        result = Math.max(result, temp);
                    }
                }
            }
        } else if (m == 4) {
            for (int p = 0; p < 5; p++) {
                for (int q = p + 1; q < 5; q++) {
                    int temp = 0;
                    for (int i = 0; i < n; i++) {
                        temp = Math.max(temp, r[i][p] + r[i][q]);
                    }
                    for (int k = 0; k < 5; k++) {
                        if (k != p && k != q) {
                            temp += maxr[k];
                        }
                    }
                    result = Math.max(result, temp);
                }
            }
        } else {
            for (int k = 0; k < 5; k++) {
                result += maxr[k];
            }
        }
        System.out.println(result);
    }
}
