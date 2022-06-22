package cloud.lintcode.dp.rollingArray;

import java.util.List;
//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 👍 1057 👎 0

public class num120Triangle_rollingArray {
    public static void main(String[] args) {
        Solution solution = new num120Triangle_rollingArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            // 只于2上一行有关, 所以只需要保存2行
            int[][] dp = new int[2][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle.get(i).get(0);
                dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle.get(i).get(i);
                for (int j = 1; j < i; j++) {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle.get(i).get(j);
                }
            }

            int res = dp[(n - 1) % 2][0];
            for (int i = 1; i < n; i++) {
                res = Math.min(res, dp[(n - 1) % 2][i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}