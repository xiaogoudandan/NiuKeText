import java.util.Scanner;

/**
 * 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。
 * 如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
 */
public class JewelTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            System.out.println(findJewel(str));
        }
    }

    private static int findJewel(String str) {
        int length=str.length();//字符串长度
        for (int i=5;i<=length;i++){//截取字符串的长度
            for (int j=0;j<length;j++){
                //接下来将字符串拼接起来
                StringBuffer stringBuffer=new StringBuffer();
                for (int k=j;k<j+i;k++){
                    stringBuffer.append(str.charAt(k%length));
                }
                String s=stringBuffer.toString();
                if(s.contains("A")&&s.contains("B")&&s.contains("C")&&s.contains("D")&&s.contains("E")){
                    return length-s.length();
                }
            }
        }
        return 0;
    }
}
