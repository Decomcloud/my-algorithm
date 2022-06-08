package cloud.lintcode.bfs;

import cloud.lintcode.common.TreeNode;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1036 👎 0

public class num110BalancedBinaryTree_divideConquerDoubleReturn {
    public static void main(String[] args) {
        Solution solution = new num110BalancedBinaryTree_divideConquerDoubleReturn().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return divideConquer(root).isBalanced;
        }

        private Result divideConquer(TreeNode node) {
            if (node == null) {
                return new Result(true, 0);
            }
            Result leftResult = divideConquer(node.left);
            Result rightResult = divideConquer(node.right);
            // 现在深度为左右最大值 +1
            int height = Math.max(leftResult.height, rightResult.height) + 1;
            boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced;
            // 左右深度不能超过1
            if (Math.abs(leftResult.height - rightResult.height) > 1) {
                isBalanced = false;
            }
            return new Result(isBalanced, height);
        }

        private class Result {
            public boolean isBalanced;
            public int height;

            public Result(boolean isBalanced, int height) {
                this.isBalanced = isBalanced;
                this.height = height;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}