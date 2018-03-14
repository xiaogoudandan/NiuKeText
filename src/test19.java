import java.util.Scanner;

public class test19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean is=true;
        if(str.length()==1){
            if(Character.isLowerCase(str.charAt(0)) ){
                System.out.println("Dislikes");
                System.exit(-1);
            }else {
                System.out.println("Likes");
                System.exit(-1);
            }
        }
        //判断是否是大写
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if (Character.isLowerCase(a) || Character.isLowerCase(b)) {
                System.out.println("Dislikes");
                System.exit(-1);
            }
            if (a == b) {
                System.out.println("Dislikes");
                System.exit(-1);
            }

        }
        //子序列
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                char a = str.charAt(i);
                char b = str.charAt(j);
                String t = str.substring(j+1);
                int n = t.indexOf(a + "");
                if(n==-1){
                    continue;
                }
                String t1 = t.substring(n+1);
                int n1=t1.indexOf(b+"");
                if(n1==-1){
                    continue;
                }
                System.out.println("Dislikes");
                System.exit(-1);
            }
        }
        System.out.println("Likes");
    }
}
