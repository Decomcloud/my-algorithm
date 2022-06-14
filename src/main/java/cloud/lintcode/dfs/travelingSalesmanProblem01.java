package cloud.lintcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yunfeng Sun
 * @date 2022/6/14 0:44
 */
public class travelingSalesmanProblem01 {

    // https://www.lintcode.com/problem/816/description
    public int minCost(int n, int[][] roads) {
        int[][] graph = constructGraph(roads, n);
        Set<Integer> visited = new HashSet<>();
        Result res = new Result();
        visited.add(1);
        dfs(1, n, visited, 0, graph, res);
        return res.minCost;
    }

    private void dfs(int city, int n, Set<Integer> visited, int cost, int[][] graph, Result res) {
        if (visited.size() == n) {
            res.minCost = Math.min(res.minCost, cost);
            return;
        }
        for (int i = 1; i < graph[city].length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            dfs(i, n, visited, cost + graph[city][i], graph, res);
            // 回溯, 移除掉
            visited.remove(i);
        }
    }

    // 构建路径数组, 从1开始, 所以n为n+1
    int[][] constructGraph(int[][] roads, int n) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[a][b], c);
        }
        return graph;
    }

    class Result {
        int minCost;

        public Result() {
            this.minCost = Integer.MAX_VALUE;
        }
    }
}
