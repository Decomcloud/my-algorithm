package cloud.lintcode.bfs;

import cloud.lintcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1350 👎 0

public class num102BinaryTreeLevelOrderTraversal_doubleQueue {
    public static void main(String[] args) {
        Solution solution = new num102BinaryTreeLevelOrderTraversal_doubleQueue().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            List<TreeNode> queue = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<TreeNode> nextQueue = new ArrayList<>();
                result.add(toIntergerList(queue));
                for (TreeNode treeNode : queue) {
                    if (treeNode.left != null) {
                        nextQueue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        nextQueue.add(treeNode.right);
                    }
                }
                queue = nextQueue;
            }
            return result;
        }

        private List<Integer> toIntergerList(List<TreeNode> queue) {
            List<Integer> level = new ArrayList<>();
            for (TreeNode treeNode : queue) {
                level.add(treeNode.val);
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}