package cloud.lintcode.dp;
//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 921 👎 0

public class num264UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new num264UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n < 0) {
                return -1;
            }
            int[] dp = new int[n];
            dp[0] = 1;
            int l2 = 0;
            int l3 = 0;
            int l5 = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.min(Math.min(dp[l2] * 2, dp[l3] * 3), dp[l5] * 5);
                if (dp[i] == dp[l2] * 2) {
                    l2++;
                }
                if (dp[i] == dp[l3] * 3) {
                    l3++;
                }
                if (dp[i] == dp[l5] * 5) {
                    l5++;
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}