package cloud.ry.day28num101;

import cloud.ry.common.TreeNode;
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1929 👎 0

public class num101SymmetricTree_order {
    public static void main(String[] args) {
        Solution solution = new num101SymmetricTree_order().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            String leftOrder = inorderTraversal(root.left);
            String rightOrder = coInorderTraversal(root.right);
            String leftPreorder = preorderTraversal(root.left);
            String rightPreorder = coPreorderTraversal(root.right);
            return leftOrder.equals(rightOrder) && leftPreorder.equals(rightPreorder);
        }

        public String preorderTraversal(TreeNode root) {
            if (root == null) {
                return " ";
            } else if (root.left == null && root.right == null) {
                return String.valueOf(root.val);
            }
            return root.val + preorderTraversal(root.left) + preorderTraversal(root.right);
        }

        public String coPreorderTraversal(TreeNode root) {
            if (root == null) {
                return " ";
            } else if (root.left == null && root.right == null) {
                return String.valueOf(root.val);
            }
            return root.val + coPreorderTraversal(root.right) + coPreorderTraversal(root.left);
        }

        public String coInorderTraversal(TreeNode root) {
            if (root == null) {
                return " ";
            } else if (root.left == null && root.right == null) {
                return String.valueOf(root.val);
            }
            return coInorderTraversal(root.right) + root.val + coInorderTraversal(root.left);
        }

        public String inorderTraversal(TreeNode root) {
            if (root == null) {
                return " ";
            } else if (root.left == null && root.right == null) {
                return String.valueOf(root.val);
            }
            return inorderTraversal(root.left) + root.val + inorderTraversal(root.right);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}