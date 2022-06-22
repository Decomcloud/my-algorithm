package cloud.lintcode.dp;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2577 👎 0

import java.util.ArrayList;
import java.util.List;

public class num300LongestIncreasingSubsequence_path {
    public static void main(String[] args) {
        Solution solution = new num300LongestIncreasingSubsequence_path().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lengthOfLIS(int[] nums) {
            // dp为包含这个点的最长上升子序列
            int[] dp = new int[nums.length];
            // 记录当前最优路径的先导点
            int[] prev = new int[nums.length];
            // 必须初始化, 否则遍历中可能比前面的数都小, 在变成了默认0
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                prev[i] = -1;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;

                    }
                }
            }
            int maxLength = 1;
            int curPos = 1;
            for (int i = 0; i < nums.length; i++) {
                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    curPos = i;
                }
            }
            List<Integer> list = new ArrayList<>();
            while (curPos != -1) {
                list.add(nums[curPos]);
                curPos = prev[curPos];
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}