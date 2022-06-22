package cloud.lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 656 👎 0

public class num329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new num329LongestIncreasingPathInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            // 排序, 从最小的点开始寻找
            // 存入[行, 列, 值]
            List<List<Integer>> points = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    points.add(Arrays.asList(i, j, matrix[i][j]));
                }
            }

            points.sort(Comparator.comparingInt(p -> p.get(2)));

            int[][] dp = new int[m][n];

            for (int i = 0; i < points.size(); i++) {
                int x = points.get(i).get(0);
                int y = points.get(i).get(1);
                dp[x][y] = 1;

                for (int j = 0; j < 4; j++) {
                    int prevX = x - dx[j];
                    int prevY = y - dy[j];
                    // 越界
                    if (prevX < 0 || prevX >= m || prevY < 0 || prevY >= n) {
                        continue;
                    }
                    // 小于该点的才计算
                    if (matrix[prevX][prevY] < matrix[x][y]) {
                        dp[x][y] = Math.max(dp[x][y], dp[prevX][prevY] + 1);
                    }
                }
            }
            int longest = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    longest = Math.max(longest, dp[i][j]);
                }
            }
            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}