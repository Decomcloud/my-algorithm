package cloud.lintcode.dp.backpack;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 23:10
 */

// https://www.jiuzhang.com/solutions/backpack
/*
在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A_{i}A
（每个物品只能选择一次且物品大小均为正整数）
样例 1：
输入：
数组 = [3,4,8,5]
backpack size = 10
输出：9
解释：装4和5.

样例 2：
输入：
数组 = [2,3,5,7]
backpack size = 12
输出：12
解释：装5和7.
*
* */

/*
状态 state
• dp[i][j] 表示前 i 个数里挑出若干个数总和 <= j 的最大和是多少
方程 function
• dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]) 如果 j >= A[i - 1]
• dp[i][j] = dp[i - 1][j] 如果 j < A[i - 1]
• 第 i 个数的下标是 i - 1，所以用的是 A[i - 1] 而不是 A[i]
初始化 initialization
• dp[0][0..m] = 0
答案 answer
• dp[n][m]
•
*
* */

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
public class lintCodeBackPack2 {
    public int shortestPath(int[] nums, int m) {
        int n = nums.length;
        // dp[i][j]表示前i个数能否挑出数组成j
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= nums[i - 1]) {
                    // dp[i - 1][j]挑出靠近j的最大数
                    // dp[i - 1][j - nums[i - 1]] 前面一个数挑出最接近差值的最大数
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    // j 比前一个数小, 不能挑选j
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
