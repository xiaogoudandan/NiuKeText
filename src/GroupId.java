import java.util.Scanner;

/**
 * 用户在输入身份证的过程中经常会输入错误，
 * 为了方便用户正确输入需要在输入过程中对用户的输入按照 6+8+4 的格式进行分组，实现一个方法接收输入过程中的身份证号，返回分组后的字符
 */
public class GroupId {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            group(s);
        }
    }


    private static void group(String s) {
        //删除所有空格
        String a="",b="",c="";// 6 8 4
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)+"").equals(" ")){
                continue;
            }
            if(a.length()<6){
                a=a+s.charAt(i);
                continue;
            }
            if(b.length()<8){
                b=b+s.charAt(i);
                continue;
            }
            if(c.length()<4){
                c=c+s.charAt(i);
                continue;
            }
        }
        if(a.length()<6){
            System.out.println(a);
        }else if(b.length()<8&&b.length()!=0){
            System.out.println(a+" "+b);
        }else if(c.length()<=4&&c.length()!=0){
            System.out.println(a+" "+b+" "+c);
        }
    }
}
