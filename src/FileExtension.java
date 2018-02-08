import java.util.Scanner;

public class FileExtension {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String []s=str.split("\\.");
        if(s.length>1){
            System.out.println(s[1]);
        }else {
            System.out.println("null");
        }
    }
}
