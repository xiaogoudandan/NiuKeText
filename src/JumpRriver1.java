import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
 * 每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，
 * 袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 */
public class JumpRriver1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int []input=new int[number];
        int []result=new int[number+1];
        for (int i=0;i<number;i++){
            input[i]=scanner.nextInt();
        }
        for (int i=0;i<number+1;i++){
            result[i]=99999;
        }
        result[0]=0;
        for (int i=1;i<=number;i++){
            for (int j=0;j<i;j++){
                 if(input[j]==0)
                     continue;
                 if(input[j]>=i-j){
                     result[i]=Math.min(result[i],result[j]+1);
                 }
            }
        }
        if(result[number]!=99999){
            System.out.println(result[number]);
        }else {
            System.out.println(-1);
        }
    }
}
