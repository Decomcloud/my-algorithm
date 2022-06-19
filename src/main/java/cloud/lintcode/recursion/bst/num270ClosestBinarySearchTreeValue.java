package cloud.lintcode.recursion.bst;

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

public class num270ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new num270ClosestBinarySearchTreeValue().new Solution();
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
            TreeNode lowerNode = lowerBound(root, target);
            TreeNode upperNode = upperBound(root, target);
            if (lowerNode == null) {
                return upperNode.val;
            }
            if (upperNode == null) {
                return lowerNode.val;
            }
            if (target - lowerNode.val > upperNode.val - target) {
                return upperNode.val;
            }
            return lowerNode.val;
        }

        private TreeNode lowerBound(TreeNode root, double target) {
            if (root == null) {
                return null;
            }
            if (target < root.val) {
                return lowerBound(root.left, target);
            }
            TreeNode lower = lowerBound(root.right, target);
            return (lower != null) ? lower : root;
        }

        private TreeNode upperBound(TreeNode root, double target) {
            if (root == null) {
                return null;
            }
            if (target >= root.val) {
                return upperBound(root.right, target);
            }
            TreeNode upper = upperBound(root.left, target);
            return (upper != null) ? upper : root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}