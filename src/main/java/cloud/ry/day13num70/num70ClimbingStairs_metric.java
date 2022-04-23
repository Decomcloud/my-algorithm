package cloud.ry.day13num70;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2382 👎 0

public class num70ClimbingStairs_metric {
    public static void main(String[] args) {
        Solution solution = new num70ClimbingStairs_metric().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int[][] M = new int[][]{{1, 1}, {1, 0}};
            M = metricPower(M, n - 1);
            return M[0][0] + M[0][1];
        }

        public int[][] metricPower(int[][] M, int n) {
            int[][] one = new int[][]{{1, 0}, {0, 1}};
            while (n > 0) {
                if (n % 2 == 1) {
                    one = metricMultiply(M, one);
                }
                M = metricMultiply(M, M);
                n = n / 2;
            }
            return one;
        }

        public int[][] metricMultiply(int[][] X, int[][] Y) {
            int[][] R = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    R[i][j] = X[i][0] * Y[0][j] + X[i][1] * Y[1][j];
                }
            }
            return R;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}