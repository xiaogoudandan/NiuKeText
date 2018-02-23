import java.util.*;

/**
 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String srt = scanner.nextLine();
        String[] s = srt.split(" ");
        int length = s.length;
        int half = length / 2;
        if (length % 2 != 0) {
            half++;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (hashMap.containsKey(s[i])) {
                int a = hashMap.get(s[i]);
                a++;
                hashMap.put(s[i], a);
            } else {
                hashMap.put(s[i], 1);
            }
        }
        Set key = hashMap.keySet();
        int sum = 0;
        Iterator<String> iterator = key.iterator();
        while (iterator.hasNext()) {
            String b = iterator.next();
            if (hashMap.get(b) >= half) {
                System.out.println(b);
                break;
            }
        }
    }
}
