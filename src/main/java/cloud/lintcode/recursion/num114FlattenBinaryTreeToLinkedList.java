package cloud.lintcode.recursion;

import cloud.lintcode.common.TreeNode;
//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1208 👎 0

public class num114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new num114FlattenBinaryTreeToLinkedList().new Solution();
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
        public void flatten(TreeNode root) {
            // 前序遍历
            flattenAndReturnLastNode(root);
        }

        // 返回已经组成链表的最后一个节点
        private TreeNode flattenAndReturnLastNode(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode leftLast = flattenAndReturnLastNode(root.left);
            TreeNode rightLast = flattenAndReturnLastNode(root.right);
            // 有左面 就需要重组
            // root.right -> left, left.last -> root.right, 返回最后一个节点
            if (leftLast != null) {
                // 把左面的最后一个节点的右面 指向跟的右节点
                leftLast.right = root.right;
                // root的右节点指向 root的左面
                root.right = root.left;
                // 清空root的左面
                root.left = null;
            }
            // 右面不为空, 那么右面的最后一个就是最后一个
            if (rightLast != null) {
                return rightLast;
            } else if (leftLast != null) {
                return leftLast;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}