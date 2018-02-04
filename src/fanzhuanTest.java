import java.util.Scanner;

/**
 * 题目描述
 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello
 */
public class fanzhuanTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String[] code=line.split(" ");
            for(int i=0;i<code.length-1;i++){
                System.out.print(code[code.length-1-i]+" ");
            }
            System.out.print(code[0]);
        }
    }
}
