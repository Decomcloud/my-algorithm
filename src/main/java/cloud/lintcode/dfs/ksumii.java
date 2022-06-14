package cloud.lintcode.dfs;


//给定 n 个不同的正整数，整数 k（1<=k<=n1<=k<=n）以及一个目标数字。
//
//在这 n 个数里面找出 k 个不同的数，使得这 k 个数的和等于目标数字，
// 你需要找出所有满足要求的方案（方案顺序不作要求）。

import java.util.ArrayList;
import java.util.List;

public class ksumii {

    public List<List<Integer>> kSumII(int[] a, int k, int target) {
        // 不需要排序
        // 需要排序
        // 1. 可以按照顺序得到结果
        // 2. 相同的在一起, 方便去重
        // Arrays.sort(a);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(a, 0, k, target, new ArrayList<>(), subsets);
        return subsets;
    }

    // 从a的index开始, 选K个数字放入subset, 满足k个数字和为target
    private void dfs(int[] a, int index, int k, int target, List<Integer> subset, List<List<Integer>> subsets) {
        // 修改subset不影响当前的结果
        if (k == 0 && target == 0) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        // 1. 已经用完了数字, 还没有得到目标和
        // 2. 剩下的数字之和为负数, 也就是当前和已经大于target, 本题中所有和为正数, 所以可以返回
        if (k == 0 || target <= 0) {
            return;
        }
        // 遍历下一个, 需要遍历之后的, 所以开始index
        for (int i = index; i < a.length; i++) {
            subset.add(a[i]);
            // 基于当前的target, 从i+ 1开始寻找下一个
            dfs(a, i + 1, k - 1, target - a[i], subset, subsets);
            // 回溯, 移除掉添加的数字
            subset.remove(subset.size() - 1);
        }
    }
}
