package cloud.lintcode.bfs;

import cloud.lintcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1460 👎 0

public class num94BinaryTreeInorderTraversal_storeValue {
    public static void main(String[] args) {
        Solution solution = new num94BinaryTreeInorderTraversal_storeValue().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            // 左根右
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            // stack中只存储需要放的值
            Stack<TreeNode> stack = new Stack<>();
            findMostLeft(root, stack);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    findMostLeft(node.right, stack);
                }

            }
            return result;
        }

        private void findMostLeft(TreeNode node, Stack<TreeNode> stack) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}