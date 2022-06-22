package cloud.lintcode.dp.rollingArray;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 23:10
 */

// https://www.jiuzhang.com/problem/knight-shortest-path-ii/
/*
在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，
骑士的初始位置是 (0, 0) ，他想要达到 (n - 1, m - 1) 这个位置，
骑士只能从左边走到右边。
找出骑士到目标位置所需要走的最短路径并返回其长度，如果骑士无法达到则返回 -1.

(x + 1, y + 2)
(x - 1, y + 2)
(x + 2, y - 1)
(x - 2, y + 1)
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
public class zhujiangKnightShortestPathII_rolling {
    // 4个点, 都向右, 不会有会跳, 如果8个点都能跳就不能用DP, 会形成环
    // 跳到i,j 就是左侧的点可以跳到
    public int shortestPath(boolean[][] grid) {
        // write your code here
        // 代表跳过来的前一个点
        int[] deltaX = {1, -1, 2, -2};
        int[] deltaY = {-2, -2, -1, -1};
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        // 代表从0,0 到i,j的最短路径
        // 只于前2列有关, 所以保存3列
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 滚动数组, 进入新行后, 需要初始化新行为最大值
                dp[i][j % 3] = Integer.MAX_VALUE;
                // 跳过障碍
                if (grid[i][j]) {
                    continue;
                }

                for (int direction = 0; direction < 4; direction++) {
                    // 从x,y跳过来
                    int x = i + deltaX[direction];
                    int y = j + deltaY[direction];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    // x, y是障碍, 此路不通
                    if (dp[x][y] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j % 3], dp[x][y % 3] + 1);
                }
            }
        }
        if (dp[n - 1][(m - 1) % 3] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n - 1][(m - 1) % 3];
    }
}
