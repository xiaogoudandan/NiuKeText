import java.util.Scanner;

public class DeletePublicChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().trim();
        String b = scanner.nextLine().trim();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (b.contains(c + "")) {
                continue;
            } else {
                stringBuffer.append(c);
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
