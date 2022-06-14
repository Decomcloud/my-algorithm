package cloud.lintcode.bfs;

import java.util.HashSet;
import java.util.Set;
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

public class num261GraphValidTree_set {
    public static void main(String[] args) {
        Solution solution = new num261GraphValidTree_set().new Solution();
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
            Set<Integer> set = new HashSet<>();
            set.add(edges[0][0]);
            set.add(edges[0][1]);
            boolean find = true;
            Set<Integer> visited = new HashSet<>();
            visited.add(0);
            while (find) {
                find = false;
                for (int col = 1; col < edges.length; col++) {
                    if (set.size() == n) {
                        return visited.size() == edges.length;
                    }
                    if (visited.contains(col)) {
                        continue;
                    }
                    int[] edge = edges[col];
                    if (set.contains(edge[0]) && set.contains(edge[1])) {
                        return false;
                    }
                    if (set.contains(edge[0]) || set.contains(edge[1])) {
                        set.add(edge[0]);
                        set.add(edge[1]);
                        visited.add(col);
                        find = true;
                    }
                }
            }
            return set.size() == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}