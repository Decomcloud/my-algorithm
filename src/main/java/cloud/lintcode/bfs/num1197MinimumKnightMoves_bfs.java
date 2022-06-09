package cloud.lintcode.bfs;

import java.util.*;
//一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。
//
// 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格
//。 
//
// 每次移动，他都可以按图示八个方向之一前进。 
//
// 
//
// 返回 骑士前去征服坐标为 [x, y] 的部落所需的最小移动次数 。本题确保答案是一定存在的。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2, y = 1
//输出：1
//解释：[0, 0] → [2, 1]
// 
//
// 示例 2： 
//
// 
//输入：x = 5, y = 5
//输出：4
//解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
// 
//
// 
//
// 提示： 
//
// 
// -300 <= x, y <= 300 
// 0 <= |x| + |y| <= 300 
// 
// Related Topics 广度优先搜索 👍 73 👎 0

public class num1197MinimumKnightMoves_bfs {
    public static void main(String[] args) {
        Solution solution = new num1197MinimumKnightMoves_bfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minKnightMoves(int x, int y) {
            Point source = new Point(0, 0);
            // 正负都相同
            x = Math.abs(x);
            y = Math.abs(y);
            int[] deltaX = {1, 1, -1, -1, 0, 2, 2, -2, -2};
            int[] deltaY = {2, -2, 2, -2, 0, 1, -1, 1, -1};
            Queue<Point> queue = new ArrayDeque<>();
            queue.offer(source);
            Map<Point, Integer> disToSrcMap = new HashMap<>();
            disToSrcMap.put(source, 0);
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                if (point.x == x && point.y == y) {
                    return disToSrcMap.get(point);
                }
                for (int i = 0; i < deltaX.length; i++) {
                    int newX = point.x + deltaX[i];
                    int newY = point.y + deltaY[i];
                    if (newX <= -2 || newX > x + 2 || y <= -2 || newY > y + 2) {
                        continue;
                    }
                    Point newPoint = new Point(newX, newY);
                    if (disToSrcMap.containsKey(newPoint)) {
                        continue;
                    }
                    queue.offer(newPoint);
                    disToSrcMap.put(newPoint, disToSrcMap.get(point) + 1);
                }
            }
            return -1;
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