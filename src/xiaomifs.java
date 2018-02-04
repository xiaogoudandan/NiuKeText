import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
 * 输入描述:
 */
public class xiaomifs {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        // list.add("ZERO");//独有Z
        //  list.add("ONE");//去掉独有0
        //    list.add("TWO");//独有w
        //list.add("THREE");//去掉后独有r
        //   list.add("FOUR");//独有u
        //list.add("FIVE");//去掉后独有f
       // list.add("SIX");//独有x
        //list.add("SEVEN");//six去掉后独有s
        //  list.add("EIGHT");//独有g
        list.add("NINE");//去掉后独有n
        for (int i = 0; i < number; i++) {
            String str = scanner.next();
            StringBuffer stringBuffer = new StringBuffer(str);
            show(stringBuffer);
            //back(str, list);
        }
    }

    private static void show(StringBuffer str) {
        int[] time = new int[10];
        while (str.toString().contains("Z")) {//去掉ZREO
            str.deleteCharAt(str.indexOf("Z"));
            str.deleteCharAt(str.indexOf("R"));
            str.deleteCharAt(str.indexOf("E"));
            str.deleteCharAt(str.indexOf("O"));
            time[2]++;
        }
        while (str.toString().contains("W")) {//去掉TWO
            str.deleteCharAt(str.indexOf("T"));
            str.deleteCharAt(str.indexOf("W"));
            str.deleteCharAt(str.indexOf("O"));
            time[4]++;
        }
        while (str.toString().contains("U")) {//去掉four
            str.deleteCharAt(str.indexOf("F"));
            str.deleteCharAt(str.indexOf("O"));
            str.deleteCharAt(str.indexOf("U"));
            str.deleteCharAt(str.indexOf("R"));
            time[6]++;
        }
        while (str.toString().contains("G")) {//去掉eight
            str.deleteCharAt(str.indexOf("E"));
            str.deleteCharAt(str.indexOf("I"));
            str.deleteCharAt(str.indexOf("G"));
            str.deleteCharAt(str.indexOf("H"));
            str.deleteCharAt(str.indexOf("T"));
            time[0]++;
        }
        while (str.toString().contains("O")) {//one
            str.deleteCharAt(str.indexOf("O"));
            str.deleteCharAt(str.indexOf("N"));
            str.deleteCharAt(str.indexOf("E"));
            time[3]++;
        }
        while (str.toString().contains("X")) {//去掉six
            str.deleteCharAt(str.indexOf("S"));
            str.deleteCharAt(str.indexOf("I"));
            str.deleteCharAt(str.indexOf("X"));
            time[8]++;
        }
        while (str.toString().contains("T")) {//three
            str.deleteCharAt(str.indexOf("T"));
            str.deleteCharAt(str.indexOf("H"));
            str.deleteCharAt(str.indexOf("R"));
            str.deleteCharAt(str.indexOf("E"));
            str.deleteCharAt(str.indexOf("E"));
            time[5]++;
        }
        while (str.toString().contains("F")) {//去掉five
            str.deleteCharAt(str.indexOf("F"));
            str.deleteCharAt(str.indexOf("I"));
            str.deleteCharAt(str.indexOf("V"));
            str.deleteCharAt(str.indexOf("E"));
            time[7]++;
        }
        while (str.toString().contains("S")) {//seven
            str.deleteCharAt(str.indexOf("S"));
            str.deleteCharAt(str.indexOf("E"));
            str.deleteCharAt(str.indexOf("V"));
            str.deleteCharAt(str.indexOf("E"));
            str.deleteCharAt(str.indexOf("N"));
            time[9]++;
        }
        while (str.toString().contains("N")) {//nine
            str.deleteCharAt(str.indexOf("N"));
            str.deleteCharAt(str.indexOf("I"));
            str.deleteCharAt(str.indexOf("N"));
            str.deleteCharAt(str.indexOf("E"));
            time[1]++;
        }
        for (int i=0;i<time.length;i++){
            for (int j=0;j<time[i];j++){
                System.out.print(i);
            }
        }
        System.out.println();
    }

    private static void back(String str, List<String> list) {
        int i = 0, j = 1;
        for (; i < str.length(); ) {
            for (; j <= str.length(); j++) {
                String a = str.substring(i, j);
                if (list.contains(a)) {
                    int an = list.indexOf(a);
                    an = ((an + 10) - 8) % 10;
                    System.out.print(an);
                    break;
                }
            }
            i = j;
            j++;
        }
    }
}
