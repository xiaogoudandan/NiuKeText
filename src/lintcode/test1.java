package lintcode;


/**
 * 给定一棵具有不同节点值的二叉查找树，删除树中与给定值相同的节点。如果树中没有相同值的节点，就不做任何处理。你应该保证处理之后的树仍是二叉查找树
 * 需要删除的节点下并没有其他子节点
 * 需要删除的节点下有一个子节点（左或右）
 * 需要删除的节点下有两个子节点（既左右节点都存在）
 * 对这三种情况分别采取的措施是：
 * <p>
 * 直接删除此结点
 * 删除此结点，将此结点父节点连接到此结点左（右）子树
 * 找出此结点右子树中的最小结点，用以代替要删除的结点，然后删除此最小结点
 */


public class test1 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int leftdeep = maxDepth(root.left);
        int rightdeep = maxDepth(root.right);
        return leftdeep > rightdeep ? leftdeep + 1 : rightdeep + 1;
    }

    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (root.val > value) {
            root.left = removeNode(root.left, value);
        }
        if (root.val < value) {
            root.right = removeNode(root.right, value);
        }
        if (root.val == value) {
            //该节点没有子节点或者只有一个子节点
            if (root.left == null || root.right == null) {
                root = (root.left == null) ? root.right : root.left;
            } else {//两个子节点都存在，需要找到右侧最小的那个节点
                TreeNode right = root.right;
                while (right.left != null) {
                    right = right.left;
                }
                root.val = right.val;
                root.right = removeNode(root.right, right.val);//删除最小的点
            }
        }
        return root;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}