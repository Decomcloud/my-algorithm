package cloud.lintcode.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
// Related Topics 数组 动态规划 👍 1054 👎 0

public class num120Triangle_recursionStoreOld {
    public static void main(String[] args) {
        Solution solution = new num120Triangle_recursionStoreOld().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            return traverse(triangle, 0, 0, new HashMap<Point, Integer>());
        }

        // 从某个点出发, 到达底部
        private int traverse(List<List<Integer>> triangle, int x, int y, Map<Point, Integer> map) {
            if (x == triangle.size()) {
                return 0;
            }
            Point point = new Point(x, y);
            // 找过了, 直接返回
            if (map.containsKey(point)) {
                return map.get(point);
            }
            int left = traverse(triangle, x + 1, y, map);
            int right = traverse(triangle, x + 1, y + 1, map);
            map.put(point, Math.min(left, right) + triangle.get(x).get(y));
            return map.get(point);
        }
    }

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}