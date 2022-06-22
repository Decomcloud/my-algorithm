package cloud.lintcode.dfs;

import cloud.lintcode.common.TreeNode;
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 338 👎 0

public class num513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new num513FindBottomLeftTreeValue().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            Result res = findNext(root, 0);
            return res.val;
        }

        private Result findNext(TreeNode root, int depth) {
            if (root == null) {
                return null;
            }
            Result leftRes = findNext(root.left, depth + 1);
            Result rightRes = findNext(root.right, depth + 1);
            if (leftRes == null && rightRes == null) {
                return new Result(depth, root.val);
            }
            if (leftRes == null) {
                return rightRes;
            }
            if (rightRes == null) {
                return leftRes;
            }
            if (leftRes.depth >= rightRes.depth) {
                return leftRes;
            }
            return rightRes;
        }


    }

    class Result {
        public int depth;
        public int val;

        public Result(int depth, int val) {
            this.depth = depth;
            this.val = val;
        }

        public Result(int depth) {
            this.depth = depth;
            this.val = Integer.MAX_VALUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}