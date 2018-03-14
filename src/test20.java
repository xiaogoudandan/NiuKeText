import java.util.LinkedList;
import java.util.Scanner;

public class test20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean isLength = true;
        LinkedList<String> stringLinkedList = new LinkedList<>();
        String t = scanner.next();
        int length = t.length();
        stringLinkedList.add(t);
        for (int i = 1; i < n; i++) {
            String t1 = scanner.next();
            if (t1.length() < length) {
                if (isLength)
                    isLength = false;
            } else {
                length = t1.length();
            }
            stringLinkedList.add(t1);
        }
        boolean isTrie = true;
        for (int i = 0; i < n - 1; i++) {
//            long a = getTrieNumber(length, stringLinkedList.get(i));
//            long b = getTrieNumber(length, stringLinkedList.get(i + 1));
//            if (a > b && isTrie) {
//                isTrie = false;
//                break;
//            }
            if(!isMax(stringLinkedList.get(i),stringLinkedList.get(i+1))){
                isTrie=false;
                break;
            }
        }
        if (isLength && isTrie) {
            System.out.println("both");
        } else if (isLength && !isTrie) {
            System.out.println("lengths");
        } else if (!isLength && isTrie) {
            System.out.println("lexicographically");
        } else if (!isLength && !isTrie) {
            System.out.println("none");
        }
    }

    private static long getTrieNumber(int n, String str) {
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - 'a' + 1) * Math.pow(10.0, n - i);
        }
        return sum;
    }

    private static boolean isMax(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length());i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);
            if ((d - c) < 0) {
                return false;
            }else if((d-c)>0){
                return true;
            }
        }
        if(b.length()>a.length()){
            return true;
        }else {
            return false;
        }
    }

}
