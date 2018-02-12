import java.util.Scanner;

public class yihuo1 {
    private static class TrieTree {
        TrieTree[] next = new TrieTree[2];
        int count = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(solve(a, m));
        }
    }

    private static long solve(int[] a, int m) {
        TrieTree trieTree = buildTrieTree(a);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += queryTrieTree(trieTree, a[i], m, 31);
        }
        return result / 2;
    }

    private static long queryTrieTree(TrieTree trieTree, int a, int m, int index) {
        if (trieTree == null)
            return 0;

        TrieTree current = trieTree;
        for (int i = index; i >= 0; i--) {
            int aDigit = (a >> i) & 1;
            int mDigit = (m >> i) & 1;
            if (aDigit == 1 && mDigit == 1) {
                if (current.next[0] == null)
                    return 0;
                current = current.next[0];
            } else if (aDigit == 0 && mDigit == 1) {
                if (current.next[1] == null)
                    return 0;
                current = current.next[1];
            } else if (aDigit == 1 && mDigit == 0) {
                long p = queryTrieTree(current.next[1], a, m, i - 1);
                long q = current.next[0] == null ? 0 : current.next[0].count;
                return p + q;
            } else if (aDigit == 0 && mDigit == 0) {
                long p = queryTrieTree(current.next[0], a, m, i - 1);
                long q = current.next[1] == null ? 0 : current.next[1].count;
                return p + q;
            }
        }
        return 0;
    }

    private static TrieTree buildTrieTree(int[] a) {
        TrieTree trieTree = new TrieTree();
        for (int i = 0; i < a.length; i++) {
            TrieTree current = trieTree;
            for (int j = 31; j >= 0; j--) {
                int digit = (a[i] >> j) & 1;
                if (current.next[digit] == null) {
                    current.next[digit] = new TrieTree();
                } else {
                    current.next[digit].count++;
                }
                current = current.next[digit];
            }
        }
        return trieTree;
    }
}