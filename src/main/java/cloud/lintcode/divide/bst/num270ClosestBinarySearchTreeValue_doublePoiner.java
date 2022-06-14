package cloud.lintcode.divide.bst;

import cloud.lintcode.common.TreeNode;
//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 116 👎 0

public class num270ClosestBinarySearchTreeValue_doublePoiner {
    public static void main(String[] args) {
        Solution solution = new num270ClosestBinarySearchTreeValue_doublePoiner().new Solution();
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
        public int closestValue(TreeNode root, double target) {
            if (root == null) {
                return 0;
            }
            TreeNode upper = root;
            TreeNode lower = root;
            while (root != null) {
                if (root.val < target) {
                    lower = root;
                    root = root.right;
                } else if (root.val > target) {
                    upper = root;
                    root = root.left;
                } else {
                    return root.val;
                }
            }
            boolean isUpperCase = Math.abs(upper.val - target) <= Math.abs(lower.val - target);
            return isUpperCase ? upper.val : lower.val;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}