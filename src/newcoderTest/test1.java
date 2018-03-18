package newcoderTest;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            int index = (a - 'A');
            if (index < ('Z' - 'A') && index >= 0) {
                char b = (char) (a + 1);
                stringBuffer.append(b);
            } else if (index == ('Z' - 'A')) {
                stringBuffer.append('A');
            } else if (index < ('z' - 'A') && index >= 'a' - 'A') {
                char b = (char) (a + 1);
                stringBuffer.append(b);
            } else if (index == ('z' - 'A')) {
                stringBuffer.append('a');
            } else {
                stringBuffer.append(a);
            }
        }
        System.out.println(stringBuffer.toString());
    }

}
