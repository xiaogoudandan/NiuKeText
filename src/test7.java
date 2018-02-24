import jdk.internal.org.objectweb.asm.Handle;

import java.util.*;

/**
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
 * 为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,
 * 小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)
 * (保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,
 * 向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,
 * 小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 */
public class test7 {
    static List<Integer> list = new ArrayList();
    static List<String> rute = new ArrayList();
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static int max = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//行
        int m = scanner.nextInt();//列
        int tili = scanner.nextInt();
        int s[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = scanner.nextInt();
            }
        }
        bianli(0, 0, 0, tili, s);
        if (max > -1)
            System.out.println(hashMap.get(max));
        else
            System.out.println("Can not escape!");
    }

    private static void fafa(int i) {
        i = 9;
    }


    public static void bianli(int i, int j, int xiaohao, int tili, int[][] s) {
        if (i == -1 || j == -1 || i == s.length || j == s[0].length) {//边缘
            return;
        }
        tili = tili - xiaohao;
        if (tili < 0)//没体力也不行
            return;
        boolean is = false;
        if (s[i][j] == 0)
            return;
        if (i == 0 && j == s[0].length - 1) {//到达了
            if (tili > max)
                max = tili;
            list.add(tili);
            StringBuffer stringBuffer = new StringBuffer();
            for (String ss : rute) {
                stringBuffer.append(ss);
            }
            stringBuffer.append("[" + Integer.toString(i) + "," + Integer.toString(j) + "]");
            hashMap.put(tili, stringBuffer.toString());
            return;
        }
        if (s[i][j] == 1) {
            s[i][j] = 0;//代表我走过了
            is = true;
            rute.add("[" + Integer.toString(i) + "," + Integer.toString(j) + "],");
            bianli(i - 1, j, 3, tili, s);
            bianli(i + 1, j, 0, tili, s);
            bianli(i, j + 1, 1, tili, s);
            bianli(i, j - 1, 1, tili, s);
            rute.remove(rute.size() - 1);
        }
        if (is) {
            s[i][j] = 1;//代表变回来
        }
    }
}
