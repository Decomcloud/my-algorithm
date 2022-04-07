package cloud.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class num257_二叉树的所有路径 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        add(root, list, "");
        return list;
    }

    public static void add(TreeNode node, List<String> list, String sb) {
        if(node == null){
            return;
        }
        if (node.left == null && node.right == null){
            sb += node.val;
            list.add(sb);
            return;
        }

        if(node.left != null){
            add(node.left, list, sb + node.val + "->");
        }
        if (node.right != null){
            add(node.right, list, sb + node.val + "->");
        }
    }

    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> nodesList = new LinkedList<>();
        LinkedList<String> pathList = new LinkedList<>();
        pathList.add(String.valueOf(root.val));
        nodesList.add(root);
        while (!nodesList.isEmpty()){
            TreeNode node = nodesList.pollLast();
            String path = pathList.pollLast();
            if (node.left == null && node.right == null){
                list.add(path);
                continue;
            }
            if(node.left != null){
                pathList.add(path + "->" + node.left.val);
                nodesList.add(node.left);
            }
            if (node.right != null){
                pathList.add(path + "->" + node.right.val);
                nodesList.add(node.right);
            }
        }
        return list;
    }


}
