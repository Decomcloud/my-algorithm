package cloud.leetCode;

import cloud.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class num107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        List<List<Integer>> revlist = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            revlist.add(list.get(i));
        }
        return revlist;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if(root == null){
            return;
        }
        if (list.size() <= level){
            list.add(level, new ArrayList<>());
        }
        List<Integer> levelList = list.get(level);
        levelList.add(root.val);

        levelOrder(root.left, list, level + 1);
        levelOrder(root.right, list, level + 1);
    }
}
