package cloud.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* 翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num226_翻转二叉树 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode treeNodeLeft = invertTree(root.left);
        TreeNode treeNodeRight = invertTree(root.right);
        root.left = treeNodeRight;
        root.right = treeNodeLeft;
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node = list.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }

        }
        return root;
    }
}
