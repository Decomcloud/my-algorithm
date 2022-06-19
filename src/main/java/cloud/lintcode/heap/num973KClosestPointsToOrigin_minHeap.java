package cloud.lintcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最
//近的 k 个点。 
//
// 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)² + (y1 - y2)² ）。 
//
// 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[1,3],[-2,2]], k = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,3],[5,-1],[-2,4]], k = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= points.length <= 10⁴ 
// -10⁴ < xi, yi < 10⁴ 
// 
// Related Topics 几何 数组 数学 分治 快速选择 排序 堆（优先队列） 👍 343 👎 0

public class num973KClosestPointsToOrigin_minHeap {
    public static void main(String[] args) {
        Solution solution = new num973KClosestPointsToOrigin_minHeap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> queue = new PriorityQueue<>(new PointComparator());
            for (int[] ints : points) {
                queue.offer(new Point(ints[0], ints[1]));
            }

            int size = Math.min(k, queue.size());
            int[][] ret = new int[k][2];
            int i = 0;
            while (i < size) {
                Point point = queue.poll();
                ret[i][0] = point.x;
                ret[i][1] = point.y;
                i++;
            }
            return ret;
        }

    }

    class PointComparator implements Comparator<Point> {
        private Point origin = new Point(0, 0);

        @Override
        public int compare(Point a, Point b) {
            // 小的在前面
            int diff = getDistance(a, origin) - getDistance(b, origin);
            if (diff == 0) {
                diff = a.x - b.x;
            }
            if (diff == 0) {
                diff = a.y - b.y;
            }
            return diff;
        }

        private int getDistance(Point a, Point origin) {
            return (a.x - origin.x) * (a.x - origin.x) + (a.y - origin.y) * (a.y - origin.y);
        }
    }

    class Point {
        public int x;
        public int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}