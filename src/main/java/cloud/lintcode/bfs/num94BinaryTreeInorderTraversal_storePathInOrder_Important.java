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

public class num94BinaryTreeInorderTraversal_storePathInOrder_Important {
    public static void main(String[] args) {
        Solution solution = new num94BinaryTreeInorderTraversal_storePathInOrder_Important().new Solution();
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
            // stack中存储的是从根节点到当前节点的整条路径
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                // 下一个点 是右子树的最小点 或者路径中最近的一个通过左子树包含当前点的点
                TreeNode node = stack.peek();
                result.add(node.val);
                if (node.right == null) {
                    // 这是他的左子树已经遍历完毕, 没有右子树, 直接Pop出来
                    node = stack.pop();
                    // 找到下一个需要遍历的节点, 弹出的是上个节点的右子树, 那么这个节点就不需要在遍历
                    while (!stack.isEmpty() && stack.peek().right == node) {
                        node = stack.pop();
                    }
                } else {
                    // 有右子树, 那么要把右子树的左节点都压入栈中
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}