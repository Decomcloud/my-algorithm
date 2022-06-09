package cloud.lintcode.bfs;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1755 👎 0

import java.util.ArrayDeque;
import java.util.Queue;

public class num200NumberOfIslands_bfs {
    public static void main(String[] args) {
        Solution solution = new num200NumberOfIslands_bfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
                return 0;
            }
            int islands = 0;
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // 找到一个没有被访问过的1就是陆地
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        bfs(grid, i, j, visited);
                        islands++;
                    }
                }
            }
            return islands;
        }

        // 找出起始点附近的岛屿, 加入以访问列表中
        private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
            // 记录4个方向的偏移量
            int[] deltaX = {0, 1, -1, 0};
            int[] deltaY = {1, 0, 0, -1};
            Queue<Coordinate> queue = new ArrayDeque<>();
            queue.offer(new Coordinate(row, col));
            visited[row][col] = true;
            while (!queue.isEmpty()) {
                Coordinate coor = queue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    int newX = coor.x + deltaX[direction];
                    int newY = coor.y + deltaY[direction];
                    // 标识合理的陆地, 不合理的或者是水直接跳过
                    if (!isValid(grid, newX, newY, visited)) {
                        continue;
                    }
                    queue.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }

        // 判断是否合理, 越界或者是否被访问过, 并且为1
        private boolean isValid(char[][] grid, int x, int y, boolean[][] visited) {
            int n = grid.length;
            int m = grid[0].length;
            if ((x < 0 || x >= n || y < 0 || y >= m)) {
                return false;
            }
            if (visited[x][y]) {
                return false;
            }
            return grid[x][y] == '1';
        }

        class Coordinate {
            int x;
            int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}