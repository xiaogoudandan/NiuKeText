import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，
 * 比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 */
public class DaffodilTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String s[]=line.split(" ");
            int a=Integer.valueOf(s[0]);
            int b=Integer.valueOf(s[1]);
            printAll(a,b);
        }
    }

    private static void printAll(int a, int b) {
        List<Integer> list=new ArrayList<>();
        for (int i=a;i<=b;i++){
            int x=i/100;
            int y=(i/10)%10;
            int z=i%10;
            if(i==x*x*x+y*y*y+z*z*z){
                list.add(i);
            }
        }
        if(list.size()==0){
            System.out.println("no");
        }else {
            for (int i=0;i<list.size();i++){
                if(i==list.size()-1){
                    System.out.println(list.get(i));
                }else {
                    System.out.print(list.get(i)+" ");
                }
            }
        }
    }
}
