package cloud.lintcode.bfs;

import cloud.lintcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 750 👎 0

public class num257BinaryTreePaths_divideConquer {
    public static void main(String[] args) {
        Solution solution = new num257BinaryTreePaths_divideConquer().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();

            if (root == null) {
                return paths;
            }
            // 这里不进行单独判断, 那么返回的值是空, 无法得到叶子节点的结果
            if (root.left == null && root.right == null) {
                paths.add("" + root.val);
                return paths;
            }
            for (String leftPath : binaryTreePaths(root.left)) {
                paths.add(root.val + "->" + leftPath);
            }
            for (String rightPath : binaryTreePaths(root.right)) {
                paths.add(root.val + "->" + rightPath);
            }
            return paths;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}