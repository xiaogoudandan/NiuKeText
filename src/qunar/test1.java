package qunar;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int number[] = new int[n];
        int[] array = new int[sum + 1];
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int a = number[i];
            for (int j = sum; j > 0; j--) {
                if (array[j] != 0) {
                    if (a + j <= sum)
                        array[a+j] = 1;
                }
                if (j == a) {
                    array[j] = 1;
                }
            }
        }
        if (array[sum]==1){
            System.out.println("perfect");
        }else {
            System.out.println("good");
        }
    }
}
