package lianjia;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 第一行一个数N，表示树的大小

 接下来N-1行，每行三个整数u,v,c，表示u,v之间有一条权值为c的边，输入保证是棵树

 接下来一行一个整数Q，表示询问个数

 接下来每行一对整数(u,v)，表示一次查询

 输出
 对于每个查询，输出答案


 样例输入
 5

 2 1 3

 3 2 2

 4 3 5

 5 4 1

 5

 2 1

 3 1

 3 5

 1 2

 4 2

 样例输出
 3

 3

 5

 3

 5
 */
public class test1 {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println(decimalFormat.format(42.04463d));
    }

    public void m1() {
        double f = 111231.5585;
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }


    /**
     * DecimalFormat转换最简便
     */

    public void m2() {
        double f = 111231.5585;
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
    }


    /**
     * String.format打印最简便
     */

    public void m3() {
        double f = 111231.5585;
        System.out.println(String.format("%.2f", f));
    }

    public void m4() {
        double f = 111231.5585;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
}
