package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1094 👎 0

public class num47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new num47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) {
                return res;
            }
            Arrays.sort(nums);
            dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
            return res;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> subset, List<List<Integer>> res) {
            if (subset.size() == nums.length) {
                res.add(new ArrayList<>(subset));
            }

            for (int i = 0; i < nums.length; i++) {
                // 不在遍历当前位置已经遍历过的
                if (visited[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(subset);
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, list, res);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}