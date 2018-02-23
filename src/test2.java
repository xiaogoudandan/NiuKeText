import java.util.*;

/**
 * 找出n个数里最小的k个
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s[] = str.split(" ");
        int k = Integer.valueOf(s[s.length - 1]);
        ArrayList<Integer> arrayList = new ArrayList<>();
        //去重复
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length - 1; i++) {
            set.add(s[i]);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            arrayList.add(Integer.valueOf(string));
        }

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int i = 0;
        if (k < s.length - 1) {
            for (; i < k - 1; i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println(arrayList.get(i));
        } else {
            for (; i < s.length - 1; i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println(arrayList.get(i));
        }
    }
}
