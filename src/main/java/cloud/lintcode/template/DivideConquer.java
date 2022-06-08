package cloud.lintcode.template;

import cloud.lintcode.common.TreeNode;

/**
 * @author Yunfeng Sun
 * @date 2022/6/8 22:43
 */
public class DivideConquer {

    // 分治在这里先处理左右,在处理跟, 是后续遍历
    public String divideConquer(TreeNode root) {
        if (root == null) {
            // 处理空树的返回结果
        }
        // 如果这里叶子节点的返回结果在最后可以通过2个空节点来的返回结果合并得到, 就可以省略
        if (root.left == null && root.right == null) {
            // 处理叶子节点的返回
        }

        String leftResult = divideConquer(root.left);
        String rightResult = divideConquer(root.right);
        // 处理左右子树合并的结果
        String holeTreeResut = leftResult + rightResult;
        return holeTreeResut;
    }
}
