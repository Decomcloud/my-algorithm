package cloud.ry.day28num101;

import cloud.ry.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
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

public class num101SymmetricTree_recursion {
    public static void main(String[] args) {
        Solution solution = new num101SymmetricTree_recursion().new Solution();
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
            Queue<TreeNode> leftQueue = new LinkedList<>();
            Queue<TreeNode> rightQueue = new LinkedList<>();
            if (root.right == null && root.left == null) {
                return true;
            } else if (root.right != null && root.left != null) {
                leftQueue.add(root.left);
                rightQueue.add(root.right);
                while (leftQueue.size() > 0) {
                    TreeNode leftNode = leftQueue.poll();
                    TreeNode rightNode = rightQueue.poll();
                    if (leftNode.val == rightNode.val) {
                        if (leftNode.left != null && rightNode.right != null) {
                            leftQueue.add(leftNode.left);
                            rightQueue.add(rightNode.right);
                        } else if (leftNode.left != null || rightNode.right != null) {
                            return false;
                        }

                        if (leftNode.right != null && rightNode.left != null) {
                            leftQueue.add(leftNode.right);
                            rightQueue.add(rightNode.left);
                        } else if (leftNode.right != null || rightNode.left != null) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean check(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left != null && right != null) {
                return left.val == right.val & check(left.left, right.right) & check(left.right, right.left);
            } else {
                return false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}