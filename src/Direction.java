import java.util.Scanner;

/**
 * 小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，
 * 注意到每个火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。
 * 小B在乘车过程中有两次清醒的时间，她到达旅程终点时处于睡梦中。出站时，她和朋友们谈论着一路的见闻，
 * 朋友们觉得很有意思，他们把N到和M之间经过车站的旗帜颜色依次列出来，然后告诉你小B记得的旗帜颜色序列，
 * 让你判断小B究竟是从N和M之间哪些方向才能看到所说颜色的旗帜，还是根本就不可能看到？颜色用字母代表，
 * 相同的字母代表相同的颜色，不同的字母则表示不同的颜色。
 * 对每组试数据，在单独的行中输出小B的旅行方向
 * forward - 由N到M方向；
 * backward -由M到N方向
 * both -两种方向都有可能；
 * invalid - 不可能看到这样的颜色序列；
 */
public class Direction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int direction = 0;
            String lone = scanner.nextLine();//获取第一行 aabcc 全部路程
            String a = scanner.nextLine().trim();
            String b = scanner.nextLine().trim();
            if (direction(lone, a, b)) {
                direction = 1;
            }
            if (direction(lone, new StringBuilder(b).reverse().toString(), new StringBuilder(a).reverse().toString())) {
                if (direction == 1) {
                    direction = 3;
                } else {
                    direction = 2;
                }
            }
            switch (direction) {
                case 0:
                    System.out.println("invalid");
                    break;
                case 1:
                    System.out.println("forward");
                    break;
                case 2:
                    System.out.println("backward");
                    break;
                case 3:
                    System.out.println("both");
                    break;
            }
        }
    }

    public static boolean direction(String lone, String a, String b) {
        //判断是否b在a的后面
        int a1 = lone.indexOf(a);
        if (a1 != -1) {
            String lone1 = lone.substring(a1+a.length());
            if (lone1.contains(b)) {
                return true;
            }
        }
        return false;
    }
}
