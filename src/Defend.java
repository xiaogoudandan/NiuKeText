import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，周
 * 围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山
 * 顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，则岗哨可以观察到另一个山峰上的烽烟是否点燃。
 * 由于小山处于环上，任意两个小山之间存在两个不同的连接通路。满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。
 * 对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题。
 */
public class Defend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] n = new int[number];
        for (int i = 0; i < number; i++) {
            n[i] = scanner.nextInt();
        }
        long sum = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < number; i++) {
            int a = 0;
            int m = 0;
            for (int j = (i + 1) % number; m < number - 1; m++) {
                if (n[i] >= a && n[j] >= a) {//没有更高的山
                    if (!set.contains(Integer.toString(i) + "_" + Integer.toString(j))) {
                        set.add(Integer.toString(i) + "_" + Integer.toString(j));
                        set.add(Integer.toString(j) + "_" + Integer.toString(i));
                        sum++;
                    }
                }
                if (n[j] > n[i]) {
                    break;
                }
                if (n[j] > a) {
                    a = n[j];
                }
                j = (j + 1) % number;
            }
        }
        System.out.println(sum);
    }
}
