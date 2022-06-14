package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1676 👎 0

public class num78Subsets_dfs {
    public static void main(String[] args) {
        Solution solution = new num78Subsets_dfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            Arrays.sort(nums);
            dfs(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> results) {
            results.add(subset);
            for (int i = start; i < nums.length; i++) {
                // 寻找1,2开头的子集
                List<Integer> newList = new ArrayList<>(subset);
                newList.add(nums[i]);
                dfs(nums, i + 1, newList, results);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}