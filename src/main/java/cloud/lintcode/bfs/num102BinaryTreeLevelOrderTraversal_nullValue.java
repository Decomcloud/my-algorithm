package cloud.lintcode.bfs;

import cloud.lintcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

public class num102BinaryTreeLevelOrderTraversal_nullValue {
    public static void main(String[] args) {
        Solution solution = new num102BinaryTreeLevelOrderTraversal_nullValue().new Solution();
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

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            List<Integer> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();
                if (head == null) {
                    // 当前值为null
                    if (level.size() == 0) {
                        // 如果level也为空, 则代表没有了
                        break;
                    }
                    result.add(level);
                    level = new ArrayList<>();
                    queue.offer(null);
                    continue;
                }
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}