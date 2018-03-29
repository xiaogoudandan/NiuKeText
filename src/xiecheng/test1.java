package xiecheng;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        LinkedList<Long> list = new LinkedList<>();
        int n = 0;
        for (int i = 0; i < number; i++) {
            long a = scanner.nextLong();
            if (a == 0) {
                n++;
            } else {
                list.add(a);
            }
        }
        for (Long l:list){
            System.out.println(l);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(0);
        }
//        StringBuffer stringBuffer1=new StringBuffer();
//        StringBuffer stringBuffer2=new StringBuffer();
//        for (int i = 0; i <number ; i++) {
//            long a=scanner.nextLong();
//            if(a==0){
//                stringBuffer2.append(a);
//            }else {
//                stringBuffer1.append(a);
//            }
//        }
//        for (int i = 0; i <stringBuffer1.length() ; i++) {
//            System.out.println(stringBuffer1.charAt(i));
//        }
//        for (int i = 0; i <stringBuffer2.length() ; i++) {
//            System.out.println(stringBuffer2.charAt(i));
//        }
    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
    /**
     *


     import java.util.Scanner;

     public class Main {
     public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     String str = scanner.nextLine();
     String[] array = str.trim().split(" ");
     String[][] arr = new String[array.length + 1][array.length + 1];
     for (int i = 0; i < array.length; i++) {
     arr[1][i + 1] = array[i];
     }
     for (int i = 0; i < array.length - 1; i++) {
     for (int j = 0; j < array.length; j++) {
     arr[i + 2][j + 1] = scanner.next();
     }
     }
     String[][] arr1 = new String[array.length + 1][array.length + 1];
     for (int i = 1; i < array.length + 1; i++) {
     for (int j = 1; j < array.length + 1; j++) {
     arr1[i][j] = arr[array.length + 1 - j][i];
     }
     }
     for (int i = 1; i <arr1.length-1 ; i++) {
     int j=1;
     for (; j <arr1.length-1 ; j++) {
     System.out.print(arr1[i][j]+" ");
     }
     System.out.println(arr1[i][j]);
     }
     int j=1;
     for (; j <arr1.length-1 ; j++) {
     System.out.print(arr1[arr1.length-1][j]+" ");
     }
     System.out.print(arr1[arr1.length-1][j]);
     }
     }

     */
}
