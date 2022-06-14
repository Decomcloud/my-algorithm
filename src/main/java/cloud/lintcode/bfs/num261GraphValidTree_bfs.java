package cloud.lintcode.bfs;

import java.util.*;
//给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 
//ai 和 bi 之间存在一条无向边。 
//
// 如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//输出: true 
//
// 示例 2: 
//
// 
//
// 
//输入: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// 不存在自循环或重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 177 👎 0

public class num261GraphValidTree_bfs {
    public static void main(String[] args) {
        Solution solution = new num261GraphValidTree_bfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            if (n > 1 && (edges == null || edges.length == 0 || edges[0].length == 0)) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int col = 0; col < edges.length; col++) {
                int[] edge = edges[col];
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }
            Set<Integer> set = new HashSet<>();
            queue.offer(0);
            set.add(0);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (Integer neighbor : map.get(poll)) {
                    if (set.contains(neighbor)) {
                        return false;
                    }
                    map.get(neighbor).remove(poll);
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
            return set.size() == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}