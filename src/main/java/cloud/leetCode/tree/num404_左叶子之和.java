package cloud.leetCode.tree;

import javafx.util.Pair;

import java.util.LinkedList;
/*
* 计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-left-leaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num404_左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, false);
    }

    public int getSum(TreeNode node, boolean isLeft) {
        int par = 0;
        if (node == null) {
            return 0;
        }
        if (isLeft && node.left == null && node.right == null) {
            par = node.val;
        }
        int left = getSum(node.left, true);
        int right = getSum(node.right, false);
        return par + left + right;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        LinkedList<Pair<TreeNode, Boolean>> nodesList = new LinkedList<>();
        nodesList.push(new Pair<>(root, false));
        Boolean isLeft;
        while (!nodesList.isEmpty()) {
            Pair<TreeNode, Boolean> pair = nodesList.pop();
            root = pair.getKey();
            isLeft = pair.getValue();
            if (root == null) {
                continue;
            }
            if (isLeft && root.left == null && root.right == null) {
                sum += root.val;
            }
            if(root.left != null){
                nodesList.push(new Pair<>(root.left, true));
            }
            if(root.right != null){
                nodesList.push(new Pair<>(root.right, false));
            }
        }
        return sum;
    }
}
