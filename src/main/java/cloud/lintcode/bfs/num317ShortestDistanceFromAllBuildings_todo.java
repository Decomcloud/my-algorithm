package cloud.lintcode.bfs;

import java.util.*;
//给你一个 m × n 的网格，值为 0 、 1 或 2 ，其中:
//
// 
// 每一个 0 代表一块你可以自由通过的 空地 
// 每一个 1 代表一个你不能通过的 建筑 
// 每个 2 标记一个你不能通过的 障碍 
// 
//
// 你想要在一块空地上建造一所房子，在 最短的总旅行距离 内到达所有的建筑。你只能上下左右移动。 
//
// 返回到该房子的 最短旅行距离 。如果根据上述规则无法建造这样的房子，则返回 -1 。 
//
// 总旅行距离 是朋友们家到聚会地点的距离之和。 
//
// 使用 曼哈顿距离 计算距离，其中距离 (p1, p2) = |p2.x - p1.x | + | p2.y - p1.y | 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//输出：7 
//解析：给定三个建筑物 (0,0)、(0,4) 和 (2,2) 以及一个位于 (0,2) 的障碍物。
//由于总距离之和 3+3+1=7 最优，所以位置 (1,2) 是符合要求的最优地点。
//故返回7。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1,0]]
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: grid = [[1]]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 是 0, 1 或 2 
// grid 中 至少 有 一幢 建筑 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 124 👎 0

public class num317ShortestDistanceFromAllBuildings_todo {
    public static void main(String[] args) {
        Solution solution = new num317ShortestDistanceFromAllBuildings_todo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }
            Map<Point, Map<Point, Integer>> distanceMap = new HashMap<>();
            Map<Point, Queue<Point>> queueMap = new HashMap<>();
            boolean hasEmpty = false;
            int obstacleNum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        Point point = new Point(i, j);
                        Map<Point, Integer> map = new HashMap<>();
                        map.put(point, 0);
                        distanceMap.put(new Point(i, j), map);
                        Queue<Point> queue = new LinkedList<>();
                        queue.offer(point);
                        queueMap.put(point, queue);
                    } else if (grid[i][j] == 0) {
                        hasEmpty = true;
                    } else {
                        obstacleNum++;
                    }
                }
            }
            if (!hasEmpty) {
                return -1;
            }
            if (distanceMap.size() == 1) {
                return 1;
            }
            int m = grid.length;
            int n = grid[0].length;
            int total = m * n - obstacleNum;
            boolean end = isEnd(distanceMap, total);

            while (!end) {
                for (Map.Entry<Point, Map<Point, Integer>> entry : distanceMap.entrySet()) {
                    Point building = entry.getKey();
                    Map<Point, Integer> buildingDistanceMap = entry.getValue();
                    Queue<Point> queue = queueMap.get(building);
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        Point poll = queue.poll();
                        construceNewPlace(grid, poll, buildingDistanceMap, queue);
                    }
                }
                end = isEnd(distanceMap, total);
            }
            Point point = getPlace(distanceMap, grid);
            if (point != null) {
                return getDistance(point, distanceMap);
            }
            return -1;
        }

        private int getDistance(Point point, Map<Point, Map<Point, Integer>> distanceMap) {
            int distance = 0;
            for (Map.Entry<Point, Map<Point, Integer>> entry : distanceMap.entrySet()) {
                distance += entry.getValue().get(point);
            }
            return distance;
        }

        private Point getPlace(Map<Point, Map<Point, Integer>> distanceMap, int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        Point point = new Point(i, j);
                        for (Map.Entry<Point, Map<Point, Integer>> entry : distanceMap.entrySet()) {
                            if (!entry.getValue().containsKey(point)) {
                                return null;
                            }
                        }
                        return point;
                    }
                }
            }
            return null;
        }

        private void construceNewPlace(int[][] grid, Point point, Map<Point, Integer> buildingDistanceMap, Queue<Point> queue) {
            int[] row = new int[]{0, 1, 0, -1};
            int[] col = new int[]{1, 0, -1, 0};
            for (int i = 0; i < row.length; i++) {
                int newX = point.x + row[i];
                int newY = point.y + col[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                    continue;
                }
                Point newPoint = new Point(newX, newY);
                if (grid[newX][newY] == 0) {
                    queue.offer(newPoint);
                    buildingDistanceMap.put(newPoint, buildingDistanceMap.get(point) + 1);
                }
            }
        }

        private boolean isEnd(Map<Point, Map<Point, Integer>> distanceMap, int total) {
            for (Map.Entry<Point, Map<Point, Integer>> entry : distanceMap.entrySet()) {
                if (entry.getValue().size() < total) {
                    return false;
                }
            }
            return true;
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