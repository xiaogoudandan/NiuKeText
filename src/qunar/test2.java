package qunar;

import java.util.*;

public class test2 {
    public static int min = Integer.MAX_VALUE;
    public static String string;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String danci = scanner.nextLine();
        String dancis = scanner.nextLine();
        string=danci;
        StringBuffer stringBuffer = new StringBuffer(danci);
        String nixu = stringBuffer.reverse().toString();
        String[] danciList = dancis.split(" ");
        List list = Arrays.asList(danciList);
        LinkedList<String> linkedList = new LinkedList<>();
        find(danci, nixu, linkedList, list, 0);
        System.out.println(min+1);
    }

    public static void find(String danci, String nixu, LinkedList<String> linkedList, List list, int number) {
        if (nixu.equals(danci)) {
            if (number < min) {
                min = number;
            }
        }
        linkedList.add(danci);
        List<String> dancis = CheckZiDian(danci, list, linkedList);
        for (String d : dancis) {
            find(d, nixu, linkedList, list, number + 1);
        }
        linkedList.remove(danci);
    }

    public static List CheckZiDian(String a, List<String> danci, LinkedList<String> linkedList) {
        List<String> list = new ArrayList<>();
        for (String str : danci) {
            if (linkedList.contains(str))
                continue;
            if (isE(a, str))
                list.add(str);
        }
        return list;
    }

    private static boolean isE(String a, String str) {
        int number1=0;
        for (int i = 0; i <a.length() ; i++) {
            char a1=a.charAt(i);
            char str1=str.charAt(i);
            if(a1!=str1){
                number1++;
            }
        }
        if(number1==1){
            return true;
        }else
            return false;
//        String[] aa = a.split("");
//        LinkedList<String> aaList = new LinkedList<>();
//        LinkedList<String> sList = new LinkedList<>();
//        for (String t : aa) {
//            aaList.add(t);
//        }
//        String[] s = str.split("");
//        for (String t : s) {
//            sList.add(t);
//        }
//        for (int i = 0; i < a.length(); i++) {
//            String t = (String) aaList.get(i);
//            if (sList.contains(t)) {
//                sList.remove(t);
//            }
//        }
//        if (sList.size() == 1) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
