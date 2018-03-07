import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while(!Q.empty())              //队列不空，执行循环
 * <p>
 * {
 * <p>
 * int x=Q.front();            //取出当前队头的值x
 * <p>
 * Q.pop();                 //弹出当前队头
 * <p>
 * Q.push(x);               //把x放入队尾
 * <p>
 * x = Q.front();              //取出这时候队头的值
 * <p>
 * printf("%d\n",x);          //输出x
 * <p>
 * Q.pop();                 //弹出这时候的队头
 * <p>
 * }
 * <p>
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正]
 */
public class test15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            controt(scanner.nextInt());
        }
    }

    private static void controt(int n) {
        int array[] = new int[n + 1];
        int number = 1;

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            int a = queue.poll();
            queue.add(a);
            int b = queue.poll();
            array[b] = number;
            number++;
        }
        array[queue.poll()] = number;
//        while (list.size() != 2) {
//            int a = list.get(0);
//            ArrayList<Integer> list1 = new ArrayList<>();
//            for (int j = 2; j < list.size(); j++) {
//                if (j % 2 == 0) {
//                    list1.add(j);
//                    array[list.get(j)] = number;
//                    number++;
//                }
//            }
//            for (int i = list1.size() - 1; i >= 0; i--) {
//                list.remove(list1.get(i).intValue());
//            }
//            list1.clear();
//        }
        int i=0;
        for (i=1;i<array.length-1;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(array[i]);
    }
}
