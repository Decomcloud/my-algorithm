package cloud.ry.day27num94;

import cloud.ry.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
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

public class num94BinaryTreeInorderTraversal_prePointer {
    public static void main(String[] args) {
        Solution solution = new num94BinaryTreeInorderTraversal_prePointer().new Solution();
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
            createPrePoint(root);
            List<Integer> ret = new LinkedList<>();
            TreeNode visitNode = root;
            while (visitNode != null) {
                if (visitNode.left != null && visitNode.left.val < 1000) {
                    visitNode = visitNode.left;
                } else {
                    ret.add(visitNode.val);
                    visitNode.val = 1000;
                    visitNode = visitNode.right;
                }
            }
            return ret;
        }

        public TreeNode createPrePoint(TreeNode root) {
            if (root == null) {
                return null;
            }
            //如果此时的根还有右孩子，说明可以继续迭代root
            else if (root.right != null) {
                //root的左子树最后一个节点
                TreeNode leftLastNode = createPrePoint(root.left);
                //不为空说明，左子树存在，那么这个节点应该在遍历后直接跳转到root
                if (leftLastNode != null) {
                    leftLastNode.right = root;
                    System.out.println(leftLastNode.val + "->" + root.val);
                }
                //root如果是其它root的左子树，此时，它的中序遍历最后一个节点在right子树中
                return createPrePoint(root.right);
            } else {
                //这时候root是最后一个右节点，因此遍历到这里时，需要返回root给到外面的循环
                //但是root，还有左子树的话，那么依旧需要寻找这个左子树的最后一个节点
                TreeNode leftLastNode = createPrePoint(root.left);
                if (leftLastNode != null) {
                    leftLastNode.right = root;
                    System.out.println(leftLastNode.val + "->" + root.val);
                }
                return root;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}