import java.util.*;

public class Restaurant01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> zhuozi = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            zhuozi.add(a);
        }
        int[] arrays = new int[n];//是否已经
        int[][] pici = new int[m][2];
        for (int i = 0; i < m; i++) {
            pici[i][0] = scanner.nextInt();
            pici[i][1] = scanner.nextInt();
        }
        zhuozi.sort(new Comparator<Integer>() {//升序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(pici, new Comparator<int[]>() {//降序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Long sum = new Long(0);//总数
        for (int i = 0; i < m; i++) {
            int a = pici[i][0];//当前客人数量
            int j = findZhuoZi(a, zhuozi);//最低桌子的下标
            while (j < n && arrays[j] != 0) {
                j++;
            }
            if (j < n) {
                sum += pici[i][1];
                arrays[j] = 1;
            }
        }
        System.out.println(sum);
    }


    /**
     * 找到小于等于clientnumber的最大位置
     *
     * @param clientNumber
     * @param arrayList
     * @return
     */
    public static int findZhuoZi(int clientNumber, ArrayList<Integer> arrayList) {
        int left = 0;
        int right = arrayList.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arrayList.get(mid) >= clientNumber) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
