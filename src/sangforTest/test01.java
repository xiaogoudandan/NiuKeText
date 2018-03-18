package sangforTest;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        Set<Integer> set =new HashSet<>();
        for (int i=0;i<n;i++){
            set.add(scanner.nextInt());
        }
        System.out.println(set.size());
    }
}
