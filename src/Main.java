import sun.plugin.javascript.navig.Link;

import java.util.*;

/**
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] numbers = new int[number];
        numbers[0] = scanner.nextInt();
        if (number == 1) {
            System.out.print(numbers[0]);
            return;
        }
        for (int i = 1; i < number; i++) {
            numbers[i] = scanner.nextInt();
            //InsertSort(numbers, i + 1);
        }
        InsertSort(numbers);
        for (int a : numbers) {
            System.out.print(a);
        }
    }

    public static boolean isBiger2(int a,int b){
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        String ab=as+bs;
        String ba=bs+as;
        if(Integer.valueOf(ab)>Integer.valueOf(ba)){
            return true;
        }else {
            return false;
        }
    }


    public static boolean isBiger(int a, int b) {
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        int i = 0;
        for (; i < Math.min(as.length(), bs.length()); i++) {
            int an = Integer.valueOf(as.charAt(i) + "");
            int bn = Integer.valueOf(bs.charAt(i) + "");
            if (an > bn)
                return true;
            else if (an == bn)
                continue;
            else {
                return false;
            }
        }
        if (as.length() > i) {
            return true;
        }
        return false;
    }

    public static void InsertSort(int[] arr, int number) {
        int j;
        int target;
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        j = number - 1;
        target = arr[j];
        while (j > 0 && isBiger(target, arr[j - 1])) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = target;
    }

    public static void InsertSort(int[] arr) {
        int j;
        int target;
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (int i=1;i<arr.length;i++) {
            j = i;
            target = arr[j];
            while (j > 0 && isBiger2(target, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }
}
//9479469393936860828217727587256726664963660859057255453552352241339937934431330729291210204184178153123115
//9479469393936860828217727587256726664963660859057255453552352241339937934431330729291210204184178153123115