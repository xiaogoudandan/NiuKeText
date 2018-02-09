import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
 */
public class LoseThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list = new int[5];
        while (scanner.hasNextInt()) {
            list[scanner.nextInt()] = 1;
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < list.length; i++) {
            if (list[i] == 0) {
                list1.add(i);
            }
        }
        StringBuffer stringBuffe = new StringBuffer();
        for (int a : list1) {
            stringBuffe.append(Integer.toString(a));
        }
        long x = Long.valueOf(stringBuffe.toString());
        System.out.println(x % 7);
    }
}
