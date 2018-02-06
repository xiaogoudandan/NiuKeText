import java.util.Scanner;

/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 */
public class MaxRestNumberTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        int length=str.length();
        int n=scanner.nextInt();//去掉的位数
        int i=0;
        int k=0;//最大数的位置
        for(;i<length-n;i++){//需要的位数操作
            int max=Integer.valueOf(str.charAt(k)+"");
            for (int j=k+1;j<n+i+1;j++){
                int x=Integer.valueOf(str.charAt(j)+"");//当前可取值
                if(max<x){
                    max=x;
                    k=j;
                }
            }
            System.out.print(max);
            k++;
        }
    }
}
