import java.util.*;

/**
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。
 * 每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，
 * 袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 */
public class JumpRriver {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        List<Integer> zhuangzi=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        List<Integer> jumpN=new ArrayList<>();
        for (int i=0;i<number;i++){
            zhuangzi.add(scanner.nextInt());
        }
        jumpN.add(0);
        jump(result,zhuangzi,jumpN,0,0,number);
        if(result.size()==0){
            System.out.println(-1);
        }else {
            result.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            System.out.println( result.get(0));
        }
    }

    /**
     *
     * @param result
     * @param zhuangzi
     * @param jumpN
     * @param i 当前第i柱子
     * @param j 当前第j路线
     * @param num 总共的数量
     */
    static int j1=0;
    private static void jump(List<Integer> result, List<Integer> zhuangzi, List<Integer> jumpN,int i,int j,int num) {
        int n=zhuangzi.get(i);//当前可以跳的数目
        if(n==0)//跳到0的柱子上 该路线失败
            return;
        if(n>num-i-1){//成功到达对面
            result.add(jumpN.get(j1));
            return;
        }
        for (int i1=1;i1<=n;i1++){
            jumpN.add(jumpN.get(j1)+1);
            j1++;
            System.out.println("路线： "+j1+"  柱子："+i);
            jump(result,zhuangzi,jumpN,i+i1,j1,num);
        }
    }
}
