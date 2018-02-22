import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrieSum2 {
    static List<ArrayList<Integer>> lists = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//1.2.3..n
        int m = scanner.nextInt();//m
        recall(1, m, n);
        for (ArrayList<Integer> arrayList : lists) {
            int i = 0;
            for (; i < arrayList.size() - 1; i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println(arrayList.get(i));
        }
        //需要回溯法
        //10 10
        //1
        //1 2
        //1 2 3
        //1 2 3 4
        //1 2 3
    }

    public static void recall(int index, int m, int n) {
        if (m == 0) {//余数
            lists.add(new ArrayList<>(list));
        }
        for (int i = index; i <= m && i <= n; i++) {
            list.add(i);
            recall(i + 1, m - i, n);
            list.remove(list.size() - 1);
        }
    }
}
