package cloud.lintcode.bfs;

import java.util.*;
//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 566 👎 0

public class num994RottingOranges_bfs {
    public static void main(String[] args) {
        Solution solution = new num994RottingOranges_bfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            Set<Point> visited = new HashSet<>();
            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        visited.add(new Point(i, j));
                    } else if (grid[i][j] == 2) {
                        visited.add(new Point(i, j));
                        queue.offer(new Point(i, j));
                    }
                }
            }
            boolean inflect = true;
            int days = 0;
            while (!queue.isEmpty() && inflect) {
                inflect = false;
                if (visited.size() == grid.length * grid[0].length) {
                    return days;
                }
                days++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point poll = queue.poll();
                    inflect = harmNeighbors(grid, poll, visited, queue) || inflect;
                }
            }
            if (visited.size() == grid.length * grid[0].length) {
                return days;
            }
            return -1;
        }

        private boolean harmNeighbors(int[][] grid, Point point, Set<Point> visited, Queue<Point> queue) {
            int[] row = new int[]{0, 1, 0, -1};
            int[] col = new int[]{1, 0, -1, 0};
            boolean affect = false;
            for (int i = 0; i < row.length; i++) {
                int newX = point.x + row[i];
                int newY = point.y + col[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                    continue;
                }
                Point newPoint = new Point(newX, newY);
                if (visited.contains(newPoint)) {
                    continue;
                }
                visited.add(newPoint);
                affect = true;
                queue.offer(newPoint);
            }
            return affect;
        }

        class Point {
            int x;
            int y;

            Point() {
                x = 0;
                y = 0;
            }

            Point(int a, int b) {
                x = a;
                y = b;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}