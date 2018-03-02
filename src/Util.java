import java.util.ArrayList;

public class Util {

    /**
     * 求所有的约数 处1和本身
     * @param n
     * @return
     */
    public static ArrayList<Integer> getYueNums(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }
}
