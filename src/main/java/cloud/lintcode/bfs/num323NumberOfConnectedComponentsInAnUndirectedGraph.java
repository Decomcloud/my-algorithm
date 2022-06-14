package cloud.lintcode.bfs;

import java.util.*;
//你有一个包含 n 个节点的图。给定一个整数 n 和一个数组 edges ，其中 edges[i] = [ai, bi] 表示图中 ai 和 bi 之间有一条
//边。 
//
// 返回 图中已连接分量的数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 5, edges = [[0, 1], [1, 2], [3, 4]]
//输出: 2
// 
//
// 示例 2: 
//
// 
//
// 
//输入: n = 5, edges = [[0,1], [1,2], [2,3], [3,4]]
//输出:  1 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 1 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai <= bi < n 
// ai != bi 
// edges 中不会出现重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 140 👎 0

public class num323NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new num323NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countComponents(int n, int[][] edges) {
            if (edges == null || edges.length == 0 || edges[0].length == 0) {
                return n;
            }
            Set<Integer> visited = new HashSet<>();
            Map<Integer, List<Integer>> pathMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                pathMap.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                pathMap.get(edge[0]).add(edge[1]);
                pathMap.get(edge[1]).add(edge[0]);
            }
            int path = 0;
            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                path++;
                Queue<Integer> queue = new LinkedList<>();
                visited.add(i);
                if (visited.size() == n) {
                    return path;
                }
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    List<Integer> neighbors = pathMap.get(poll);
                    for (int neighbor : neighbors) {
                        if (visited.contains(neighbor)) {
                            continue;
                        }
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }

            }
            return path;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}