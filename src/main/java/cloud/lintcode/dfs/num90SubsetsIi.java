package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 853 👎 0

public class num90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new num90SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            Arrays.sort(nums);
            dfs(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
            res.add(subset);
            for (int i = start; i < nums.length; i++) {
                if (i != 0 && i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(subset);
                list.add(nums[i]);
                dfs(nums, i + 1, list, res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}