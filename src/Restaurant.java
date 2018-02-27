import com.sun.applet2.AppletParameters;

import java.util.*;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
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
        for (int i = 0; i < zhuozi.size(); i++) {
            int a = zhuozi.get(i);
            if (!hashMap.containsKey(a)) {
                hashMap.put(a, i);
            }
        }
        for (int i = 1; i < zhuozi.get(0); i++) {
            int iii = hashMap.get(zhuozi.get(0));
            hashMap.put(i, iii);
        }
        for (int i = 1; i < n; i++) {
            int a = zhuozi.get(i - 1);
            int b = zhuozi.get(i);
            if (b != a) {
                int iii = hashMap.get(b);
                for (int ii = a + 1; ii < b; ii++) {
                    hashMap.put(ii, iii);
                }
            }
        }

        Arrays.sort(pici, new Comparator<int[]>() {//降序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Long sum = new Long(0);//总数
        for (int i = 0; i < m; i++) {
            int a = pici[i][0];//当前客人数量
            if(a>zhuozi.get(zhuozi.size()-1)){
                continue;
            }
           // int j = findZhuoZi(a, zhuozi);//最低桌子的下标
            int j = hashMap.get(a);
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
