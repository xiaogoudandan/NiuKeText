import java.util.HashMap;
import java.util.Scanner;

/**
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 */
public class TreeTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        HashMap<Integer, Integer> tree = new HashMap<>();
        HashMap<Integer, Integer> nodeNumber = new HashMap<>();
        tree.put(0, 1);
        nodeNumber.put(0,0);
        int [][] none=new int[number][2];
        int noneNumber=0;

        int max = 1;
        for (int i = 0; i < number - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(!tree.containsKey(a)||nodeNumber.get(a)>=2){
//                noneNumber++;
//                none[noneNumber][0]=a;
//                none[noneNumber][1]=b;
                continue;
            }
            int deep = tree.get(a);
            tree.put(b, deep + 1);
            nodeNumber.put(a,nodeNumber.get(a)+1);
            nodeNumber.put(b,0);
            if (max < deep + 1) {
                max = deep + 1;
            }
            System.out.println(Integer.toString(a)+"deep:"+Integer.toString(deep));
            System.out.println(Integer.toString(b)+"deep:"+Integer.toString(deep+1));
        }
        int maxNone=noneNumber;
//        while (noneNumber!=0){
//             for(int i=0;i<maxNone;i++){
//                 if(none[i][0]!=-1){
//                     int a = none[i][0];
//                     int b = none[i][1];
//                     if(!tree.containsKey(a)){
//                         continue;
//                     }
//                     int deep = tree.get(a);
//                     tree.put(b, deep + 1);
//                     if (max < deep + 1) {
//                         max = deep + 1;
//                     }
//                     none[i][0]=-1;
//                     noneNumber--;
//                     System.out.println(Integer.toString(a)+"deep:"+Integer.toString(deep));
//                     System.out.println(Integer.toString(b)+"deep:"+Integer.toString(deep+1));
//                 }
//             }
//        }
        System.out.print(max);
    }
}
