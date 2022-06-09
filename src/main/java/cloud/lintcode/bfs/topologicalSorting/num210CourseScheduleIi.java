package cloud.lintcode.bfs.topologicalSorting;

import java.util.*;
//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 639 👎 0

public class num210CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new num210CourseScheduleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // key 为当前课程, value为后修课程
            Map<Integer, List<Integer>> graph = new HashMap<>();
            // key 为课程, value为学习该课程需要的前置课程数目
            Map<Integer, Integer> preRequireCount = new HashMap<>();
            // 初始化
            for (int i = 0; i < numCourses; i++) {
                graph.put(i, new ArrayList<>());
                preRequireCount.put(i, 0);
            }

            for (int[] edge : prerequisites) {
                // 获取先修课
                int course = edge[edge.length - 1];
                List<Integer> preRequire = graph.get(course);
                for (int preCourse : edge) {
                    if (preCourse == course) {
                        continue;
                    }
                    // 添加该先修课的后置课
                    preRequire.add(preCourse);
                    // 该后置课需要的前置课数目增加
                    preRequireCount.put(preCourse, preRequireCount.get(preCourse) + 1);
                }
                graph.put(course, preRequire);
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                // 放入没有前置课需求的课程
                if (preRequireCount.get(i) == 0) {
                    queue.offer(i);
                }
            }

            int numChoose = 0;
            int[] topoOrder = new int[numCourses];

            while (!queue.isEmpty()) {
                Integer nowPos = queue.poll();
                topoOrder[numChoose] = nowPos;
                numChoose++;
                for (int i = 0; i < graph.get(nowPos).size(); i++) {
                    int nextPos = graph.get(nowPos).get(i);
                    // 学习后, 该后置课需要的前置课数目 - 1
                    preRequireCount.put(nextPos, preRequireCount.get(nextPos) - 1);
                    // 如果该后置课 所需要的前置课为0, 那么就可以学习
                    if (preRequireCount.get(nextPos) == 0) {
                        queue.add(nextPos);
                    }
                }
            }
            return (numChoose == numCourses) ? topoOrder : new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}