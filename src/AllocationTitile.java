import java.util.*;

/**
 * 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队，每个出题人都出了一些有趣的题目，
 * 而我们现在想把这些题目组合成若干场考试出来，在选题之前，我们对题目进行了盲审，并定出了每道题的难度系统。
 * 一场考试包含3道开放性题目，假设他们的难度从小到大分别为a,b,c，我们希望这3道题能满足下列条件：
 * a<=b<=c
 * b-a<=10
 * c-b<=10
 * 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
 * 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求，
 * 然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 */
public class AllocationTitile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        //List<Integer> linkedList = new LinkedList<>();
        //List<Integer> numberList = new ArrayList<>();
        int number = scanner.nextInt();
        //.add(number);
        for (int i = 0; i < number; i++) {
            list.add(scanner.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
//        for (int i = 0; i < number; i++) {
//            linkedList.add(list.get(i));
//        }
//        int j = 0;
//        int m=0;
//        for (; j < list.size()-1; j++){
//            if((list.get(j+1)-linkedList.get(j)>10)){
//
//            }
//        }
        int titleNumber = 0;
        int t = 1;
        for (int i = 1; i < list.size(); i++) {
            if(t<3) {
                if ((list.get(i) - list.get(i - 1) <= 10)) {
                    t++;
                } else if ((list.get(i) - list.get(i - 1) <= 20 && t == 1)) {//中间可以加一个
                    titleNumber++;
                    t = 1;
                } else {
                    titleNumber = titleNumber + 3 - t;
                    t = 1;
                }
            }else {
                t=1;
            }
        }
        titleNumber = titleNumber + 3 - t;
        System.out.println(titleNumber);
    }
}
