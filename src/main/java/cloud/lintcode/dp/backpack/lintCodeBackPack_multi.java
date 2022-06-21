package cloud.lintcode.dp.backpack;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 23:10
 */

// https://www.lintcode.com/problem/440/
/*
描述
给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?

不能将一个物品分成小块.
放入背包的物品的总大小不能超过 m.

样例

样例 1:
输入: A = [2, 3, 5, 7], V = [1, 5, 2, 4], m = 10
输出: 15
解释: 装入三个物品 1 (A[1] = 3, V[1] = 5), 总价值 15

样例 2:
输入: A = [1, 2, 3], V = [1, 2, 3], m = 5
输出: 5
解释: 策略不唯一. 比如, 装入五个物品 0 (A[0] = 1, V[0] = 1)

state:
dp[i][j] 表示前i个物品挑出一些放到 j 的背包里的最大价值和

function:
dp[i][j] = max(dp[i - 1][j - count * A[i - 1]] + count * V[i - 1])
其中 0 <= count <= j / A[i - 1]

initialization:
dp[0][0..m] = 0

answer:
dp[n][m]
*
*/

public class lintCodeBackPack_multi {
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
                    /*
                    int count = j / a[i - 1] + 1;
                    dp[i][j] = max(dp[i - 1][j],
                    dp[i - 1][j - A[i - 1]] + V[i - 1],
                    dp[i - 1][j - A[i - 1] * 2] + V[i - 1] * 2,
                    ...)
                    // 其实是当前的状态 少选一个, 在加上 算出最大值
                    dp[i][j - A[i - 1]] +  V[i - 1]
                     */
                    dp[i][j] = Math.max(dp[i - 1][j],
                            // 这里的dp[i - 1][j - a[i - 1]] + v[i - 1]可以去掉, 不明白为啥,
                            // 道理上是i个肯定不会比i - 1价值小
                            Math.max(dp[i - 1][j - a[i - 1]] + v[i - 1],
                                    dp[i][j - a[i - 1]] + v[i - 1]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }


            }
        }
        return dp[n][m];
    }
}
