package sangforTest;

import java.util.Scanner;


public class test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if (b.contains("?")) {
            if (a.length() == b.length()) {
                if (b.charAt(b.length() - 1) == '?') {
                    if (a.indexOf(b.substring(0, b.length() - 1)) == 0) {
                        System.out.println("match");
                    } else {
                        System.out.println("unmatch");
                    }
                } else {
                    System.out.println("unmatch");
//                if(a.length()!=b.length()){
//                    System.out.println("unmatch");
//                }else {
//                    int index = b.indexOf("*");
//                    String b1 = b.substring(0, index);
//                    String b2 = b.substring(index + 1, b.length() - 1);
//                    String a1 = a.substring(0, index);
//                    String a2 = a.substring(index + 1, b.length() - 1);
//                    if(a1.equals(b1)&&a2.equals(b2)){
//                        System.out.println("match");
//                    }else {
//                        System.out.println("unmatch");
//                    }
//                }
                }
            } else {
                System.out.println("unmatch");
            }
        } else if (b.contains("*")) {
            if (b.charAt(b.length() - 1) == '*') {
                if (a.indexOf(b.substring(0, b.length()-1)) == 0) {
                    System.out.println("match");
                } else {
                    System.out.println("unmatch");
                }
            } else {
                if(a.length()<b.length()){
                    System.out.println("unmatch");
                }else {
                    int index = b.indexOf("*");
                    String b1 = b.substring(0, index);
                    String b2 = b.substring(index + 1, b.length());
                    String a1 = a.substring(0, index);
                    String a2 = a.substring(a.length() - b2.length(), a.length());
                    if (b1.equals(a1) && b2.equals(a2)) {
                        System.out.println("match");
                    } else {
                        System.out.println("unmatch");
                    }
                }
            }
        }else {
            if(a.equals(b)){
                System.out.println("match");
            }else {
                System.out.println("unmatch");
            }
        }
    }
}
