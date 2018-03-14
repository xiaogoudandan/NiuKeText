import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小易邀请你玩一个数字游戏，小易给你一系列的整数。
 * 你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，
 * 然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。
 * 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.
 * 如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，
 * 让你找出无法从n个数中选取部分求和的数字中的最小数。
 */
public class test17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();//当前所有数
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            list.add(n);
            sum += n;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ArrayList<LinkedList<Integer>> all = new ArrayList<>();
        all.add(list);
        for (int i = 1; i < sum; i++) {
            int j=0;
            for ( j=0; j < i; j++) {
                int t = i - j;
                LinkedList<Integer> tList = all.get(j);
                if (tList.contains(t))
                {
                    LinkedList<Integer> linkedList = new LinkedList<>(tList);
                    linkedList.remove((Integer) t);
                    all.add(linkedList);
                    break;
                }
            }
            if(j==i){
                System.out.println(i);
                break;
            }
        }
        System.out.println(++sum);
    }
}
