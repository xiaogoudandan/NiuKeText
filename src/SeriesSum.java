import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 */
public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String s[]=line.split(" ");
            int a=Integer.valueOf(s[0]);
            int b=Integer.valueOf(s[1]);
            printSum(a,b);
        }
    }

    private static void printSum(int a, int number) {
        double sum=a;
        double d=a;
        for (int i=1;i<number;i++){
            d=Math.sqrt(d);
            sum=sum+d;
        }
        DecimalFormat decimalFormat=new DecimalFormat("#0.00");
        System.out.println(decimalFormat.format(sum));
    }
}
