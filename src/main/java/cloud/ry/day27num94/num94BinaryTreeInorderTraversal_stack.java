package cloud.ry.day27num94;

import cloud.ry.common.TreeNode;

import java.util.LinkedList;
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
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1446 👎 0

public class num94BinaryTreeInorderTraversal_stack {
    public static void main(String[] args) {
        Solution solution = new num94BinaryTreeInorderTraversal_stack().new Solution();
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
            Stack<TreeNode> roots = new Stack<>();
            List<Integer> ret = new LinkedList<>();
            TreeNode visitNode = root;
            while (roots.size() > 0 || visitNode != null) {
                //当visit为null，说明某个root的右孩子为空，这个节点的遍历完成，返回寻找它的父亲；
                if (visitNode == null) {
                    visitNode = roots.pop();
                    ret.add(visitNode.val);
                    // 从stack中弹出, 左已经遍历完毕
                    visitNode = visitNode.right;
                } else if (visitNode.left != null) {
                    // 有左节点, 压栈
                    roots.push(visitNode);
                    visitNode = visitNode.left;
                } else {
                    // 该节点没有左节点
                    //当前子树最左节点
                    //val加入list，表示已经遍历；
                    ret.add(visitNode.val);
                    //如果右孩子也是null，则是一个叶子；
                    if (visitNode.right == null && roots.size() > 0) {
                        visitNode = roots.pop();
                        //遍历父节点；
                        ret.add(visitNode.val);
                    }
                    // 如果visitNode.right为空, 并且stack为空, 说明到达最后一个节点
                    //获取右子树的root；
                    visitNode = visitNode.right;
                }
            }
            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}