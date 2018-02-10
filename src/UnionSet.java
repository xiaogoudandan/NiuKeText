import java.util.*;

/**
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。
 */
public class UnionSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a; i++) {
            set.add(scanner.nextInt());
        }
        for (int i = 0; i < b; i++) {
            set.add(scanner.nextInt());
        }
        List<Integer> list = new ArrayList<>();
        for (Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            list.add(it.next());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()-1)
                System.out.print(list.get(i));
            else
                System.out.print(list.get(i) + " ");
        }
    }
}
