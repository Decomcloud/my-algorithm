package cloud.lintcode.dfs;

import java.util.*;
//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 2002 👎 0

public class num39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new num39CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int[] uniqueNums = removeDuplicatesAndSort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            dfs(uniqueNums, 0, target, new ArrayList<>(), res);
            return res;
        }

        private int[] removeDuplicatesAndSort(int[] candidates) {
            Set<Integer> set = new HashSet<>();
            for (int num : candidates) {
                set.add(num);
            }
            int[] uniqueNums = new int[set.size()];
            int i = 0;
            for (int num : set) {
                uniqueNums[i++] = num;
            }
            Arrays.sort(uniqueNums);
            return uniqueNums;
        }

        private void dfs(int[] nums, int index, int remainingTarget, List<Integer> combination, List<List<Integer>> res) {
            if (remainingTarget == 0) {
                res.add(new ArrayList<>(combination));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (remainingTarget < nums[i]) {
                    return;
                }
                combination.add(nums[i]);
                // 这里传入i, 因为可以重复使用
                dfs(nums, i, remainingTarget - nums[i], combination, res);
                combination.remove(combination.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}