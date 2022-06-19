package cloud.lintcode.recursion.bst;

import cloud.lintcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给定二叉搜索树的根 root 、一个目标值 target 和一个整数 k ，返回BST中最接近目标的 k 个值。你可以按 任意顺序 返回答案。 
//
// 题目 保证 该二叉搜索树中只会存在一种 k 个值集合最接近 target 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//输出: [4,3] 
//
// 示例 2: 
//
// 
//输入: root = [1], target = 0.000000, k = 1
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点总数为 n 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 进阶：假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（ n = total nodes ）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二叉树 堆（优先队列） 👍 109 👎 0

public class num272ClosestBinarySearchTreeValueIi {
    public static void main(String[] args) {
        Solution solution = new num272ClosestBinarySearchTreeValueIi().new Solution();
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
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> list = new ArrayList<>();
            findSortedList(root, list);
            int index = findFirstBiggerIndex(list, target);
            int left = index - 1;
            int right = index;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (left < 0) {
                    res.add(list.get(right));
                    right++;
                } else if (right >= list.size()) {
                    res.add(list.get(left));
                    left--;
                } else {
                    if (Math.abs(list.get(left) - target) >= Math.abs(list.get(right) - target)) {
                        res.add(list.get(right));
                        right++;
                    } else {
                        res.add(list.get(left));
                        left--;
                    }
                }
            }
            return res;


        }

        private void findSortedList(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            findSortedList(root.left, list);
            list.add(root.val);
            findSortedList(root.right, list);
        }

        private int findFirstBiggerIndex(List<Integer> list, double target) {
            int start = 0;
            int end = list.size() - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (mid < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (start >= target) {
                return start;
            }
            if (end >= target) {
                return end;
            }
            return list.size() - 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}