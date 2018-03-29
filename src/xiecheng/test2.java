package xiecheng;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String str = scanner.nextLine();
//        String[] array = str.trim().split(" ");
//        String[][] arr = new String[array.length + 1][array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            arr[1][i + 1] = array[i];
//        }
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = 0; j < array.length; j++) {
//                arr[i + 2][j + 1] = scanner.next();
//            }
//        }


//        Queue<String> queue = new LinkedBlockingQueue<>();
//        ArrayList<String> list = new ArrayList<>();
//        while (scanner.hasNext()) {
//            queue.add(scanner.next());
//        }
//        int a = queue.size();
//        int n = (int) Math.sqrt(a);
//        String[][] arr = new String[n + 1][n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                arr[i][j] = queue.poll();
//            }
//        }
//        String[][] arr1 = new String[n + 1][n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                arr1[i][j] = arr[n + 1 - j][i];
//            }
//        }
//        for (int i = 1; i < arr1.length - 1; i++) {
//            int j = 1;
//            for (; j < arr1.length - 1; j++) {
//                System.out.print(arr1[i][j] + " ");
//            }
//            System.out.println(arr1[i][j]);
//        }
//        int j = 1;
//        for (; j < arr1.length - 1; j++) {
//            System.out.print(arr1[arr1.length - 1][j] + " ");
//        }
//        System.out.print(arr1[arr1.length - 1][j]);
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
                if(j<array.length)
                    System.out.print(arr[array.length + 1 - j][i]+ " ");
                //arr1[i][j] = arr[array.length + 1 - j][i];
                else
                    System.out.println(arr[array.length + 1 - j][i]);
            }
        }
//        for (int i = 1; i < arr1.length - 1; i++) {
//            int j = 1;
//            for (; j < arr1.length - 1; j++) {
//                System.out.print(arr1[i][j] + " ");
//            }
//            System.out.println(arr1[i][j]);
//        }
//        int j = 1;
//        for (; j < arr1.length - 1; j++) {
//            System.out.print(arr1[arr1.length - 1][j] + " ");
//        }
//        System.out.print(arr1[arr1.length - 1][j]);
    }


}
