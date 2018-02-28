import java.util.Scanner;

public class test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        Long sum = new Long(0);
        for (long i = n; i > 0; i = i / 2) {
            long num = (i + 1) / 2;
            sum += (i + 1) /2* num ;
        }
        System.out.println(sum);
    }
}
