package cloud.leetCode.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
/*
* 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int dep = Integer.MAX_VALUE;
        if(root.left != null){
            dep = Math.min(minDepth(root.left), dep);
        }

        if(root.right != null){
            dep = Math.min(minDepth(root.right), dep);
        }
        return dep + 1;
    }

    public int minDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        stack.add(new Pair<>(root, 1));
        int depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root.left == null && root.right == null) {
                return current_depth;
            }
            depth = Math.min(depth, current_depth);
            if(root.left != null){
                stack.add(new Pair<>(root.left, current_depth + 1));
            }
            if(root.right != null){
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }
        return depth;
    }

}
