import java.util.Scanner;

/**
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 */
public class test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int array[] = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while (left < right) {
            if (array[left] < array[right]) {
                array[left + 1] += array[left];
                count++;
                left++;
            } else if (array[left] > array[right]) {
                array[right - 1] += array[right];
                count++;
                right--;
            } else {
                right--;
                left++;
            }
        }

        System.out.println(count);
    }
}
