import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * 例子：Have you ever gone shopping and
 * e
 */
public class FirstThreeTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(scanner.nextLine());
        HashMap<Character,Integer> hashMap=new HashMap<>();
        String s=stringBuffer.toString();
        for(int i=0;i<s.                            length();i++){
            char a=s.charAt(i);
            if((a+"").equals(" ")){
                continue;
            }
            if(a>'a'||a>'A'){
                if(hashMap.containsKey(a)){
                    int number = hashMap.get(a);
                    if(number==2){
                        System.out.println(a);
                        break;
                    }else {
                        number++;
                        hashMap.put(a,number);
                    }
                }else {
                    hashMap.put(a,1);
                }
            }
        }
    }

}
