package newcoderTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 妞妞参加完Google Girl Hackathon之后,打车回到了牛家庄。
 * 妞妞需要支付给出租车司机车费s元。妞妞身上一共有n个硬币，第i个硬币价值为p[i]元。
 * 妞妞想选择尽量多的硬币，使其总价值足以支付s元车费(即大于等于s)。
 * <p>
 * 但是如果从妞妞支付的这些硬币中移除一个或者多个硬币，剩下的硬币总价值还是足以支付车费的话，出租车司机是不会接受的。例如: 妞妞使用价值为2，5，7的硬币去支付s=11的车费,出租车司机是不会接受的，因为价值为2这个硬币是可以移除的。
 * <p>
 * 妞妞希望能选取最大数量的硬币，使其总价值足以支付车费并且出租车司机能接受。
 * 妞妞希望你能帮她计算最多可以支付多少个硬币。
 * <p>
 * 输入描述:
 * 输入包括两行, 第一行包括两个正整数n和s(1 <= n <= 10, 1 <= s <= 1000), 表示妞妞的硬币个数和需要支付的车费。
 * 第二行包括n个正整数p[i] (1 <= p[i] <= 100)，表示第i个硬币的价值。
 * 保证妞妞的n个硬币价值总和是大于等于s。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数, 表示妞妞最多可以支付的硬币个数。
 * <p>
 * 输入例子1:
 * 5 9
 * 4 1 3 5 4
 * <p>
 * 输出例子1:
 * 3
 */
public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int s = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(scanner.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int sum = 0;
        int n = 0;
        for (int i = 0; i < number; i++) {
            int a = list.get(i);
            sum += a;
            if (sum >= s && (sum - list.get(0)) >= s) {//当前的a不符合要求
                break;
            } else {
                n++;
            }
        }
        System.out.println(n);
    }
}
