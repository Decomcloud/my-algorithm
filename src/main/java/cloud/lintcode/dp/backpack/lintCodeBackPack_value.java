package cloud.lintcode.dp.backpack;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 23:10
 */

// https://www.lintcode.com/problem/125/
/*
有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.

问最多能装入背包的总价值是多大?

A[i], V[i], n, m 均为整数
你不能将物品进行切分
你所挑选的要装入背包的物品的总大小不能超过 m
每个物品只能取一次
m <= 1000m<=1000\
len(A),len(V)<=100len(A),len(V)<=100


输入：

m = 10
A = [2, 3, 5, 7]
V = [1, 5, 2, 4]
输出：9
解释：装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9

样例 2：
输入：
m = 10
A = [2, 3, 8]
V = [2, 5, 8]
输出：10
解释：装入 A[0] 和 A[2] 可以得到最大价值, V[0] + V[2] = 10

state:
dp[i][j] 表示前i个物品挑出一些放到 j 的背包里的最大价值和

function:
dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1])

initialization:
dp[0][0..m] = 0

answer:
dp[n][m]
*
*/

public class lintCodeBackPack_value {
    public int backPackII(int m, int[] a, int[] v) {
        // write your code here
        if (a == null || v == null) {
            return 0;
        }
        int n = a.length;
        // 前i个物品挑出一些放到j的背包里的价值和
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= a[i - 1]) {
                    // dp[i - 1][j] 表示前i个物品, 放到最大背包为j的里面的价值
                    // dp[i - 1][j - a[i - 1]] 表示选择当前位置的物品, 所以背包体积剩余 j - a[i-1],
                    // 找出i-1中体积为该值的最大值,在加上当前位置的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
