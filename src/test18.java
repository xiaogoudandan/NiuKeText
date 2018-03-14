import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int left = 0;
        int right = 1;
        while (true) {
            list.add(left + right);
            left = right;
            right = list.get(list.size() - 1);
            if (n >= left && n <= right) {
                int l = n - left;
                int r = right - n;
                System.out.println(Math.min(l, r));
                break;
            }

        }
    }
}
