package cloud.lintcode.bfs;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 23:10
 */

// https://www.lintcode.com/problem/611/
/*
给定骑士在棋盘上的 初始 位置(一个2进制矩阵 0 表示空 1 表示有障碍物)，
找到到达 终点 的最短路线，返回路线的长度。如果骑士不能到达则返回 -1
起点跟终点必定为空.
骑士不能碰到障碍物.
路径长度指骑士走的步数.
如果骑士的位置为 (x,y)，他下一步可以到达以下这些位置:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
*
* */

import java.util.*;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */
public class LintCode611KnightShortestPath_bfs {

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] deltaX = {1, 1, -1, -1, 0, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 0, 1, -1, 1, -1};
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(source);
        Map<Integer, Integer> disToSrcMap = new HashMap<>();
        int colCnt = grid[0].length;
        // 行坐标 * 列数 + 列坐标
        disToSrcMap.put(source.x * colCnt + source.y, 0);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int curPointKey = point.x * colCnt + point.y;
            if (point.x == destination.x && point.y == destination.y) {
                return disToSrcMap.get(curPointKey);
            }
            for (int i = 0; i < deltaX.length; i++) {
                int newX = point.x + deltaX[i];
                int newY = point.y + deltaY[i];
                if (!isValid(newX, newY, grid)) {
                    continue;
                }
                Point newPoint = new Point(newX, newY);
                int newPointKey = newX * colCnt + newY;
                if (disToSrcMap.containsKey(newPointKey)) {
                    continue;
                }
                queue.offer(newPoint);
                disToSrcMap.put(newPointKey, disToSrcMap.get(curPointKey) + 1);
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return !grid[x][y];
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

        // 有时point是写死的, 重写这些
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
