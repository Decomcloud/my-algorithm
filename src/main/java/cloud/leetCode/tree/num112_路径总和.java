package cloud.leetCode.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
/*
* 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null){
            sum -= root.val;
            if(root.right == null && root.left == null){
                return sum == 0;
            }
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return false;
        }
        stack.add(new Pair<>(root, sum));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_val = current.getValue() - root.val;
            if (root.left == null && root.right == null && current_val == 0) {
                return true;
            }
            if(root.left != null){
                stack.add(new Pair<>(root.left, current_val));
            }
            if(root.right != null){
                stack.add(new Pair<>(root.right, current_val));
            }
        }
        return false;
    }
}
