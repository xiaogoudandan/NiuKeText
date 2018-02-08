import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，请实现以下函数int[][] merge(int[][] dateRangePrices)，输入是某个酒店多个日期段的价格，每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准， 请以以下规则合并并输出合并结果：
 1.相邻两天的价格如果相同，那么这两个日期段应该合并
 2.合并的结果应该以起始日期从小到大排序
 */
public class HotelPrice {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> a=new LinkedList<>();
        List<String> b=new LinkedList<>();
        List<String> c=new LinkedList<>();
        List<String> d=new LinkedList<>();
        String str="";
        while ((str=bf.readLine())!=null){
            String[] strs =str.split(" ");
            a.add(strs[0]);
            b.add(strs[1]);
            c.add(strs[2]);
        }
        sort(a,b,c);
        for(int i=0;i<a.size();){
            int m=i;
            for (int j=i+1;j<a.size();j++){
                if(c.get(j).equals(c.get(i))){
                    m=j;
                }else {
                    break;
                }
            }
            if(m==i){//不相同
                d.add("["+a.get(i)+","+b.get(i)+","+c.get(i)+"]");
                i++;
            }else {
                d.add("["+a.get(i)+","+b.get(m)+","+c.get(i)+"]");
                i=m+1;
            }
        }
        for (int i=0;i<d.size();i++){
            if(i==d.size()-1){
                System.out.print(d.get(i));
            }else {
                System.out.print(d.get(i)+",");
            }
        }
    }

    private static void sort(List<String> a, List<String> b, List<String> c) {
    }
}


