package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yunfeng Sun
 * @date 2022/6/14 0:44
 */
public class travelingSalesmanProblem02 {

    // https://www.lintcode.com/problem/816/description
    public int minCost(int n, int[][] roads) {
        int[][] graph = constructGraph(roads, n);
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Result res = new Result();
        visited.add(1);
        dfs(1, n, visited, path, 0, graph, res);
        return res.minCost;
    }

    private void dfs(int city, int n, Set<Integer> visited, List<Integer> path, int cost, int[][] graph, Result res) {
        if (visited.size() == n) {
            res.minCost = Math.min(res.minCost, cost);
            return;
        }
        for (int i = 1; i < graph[city].length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (hasBetterPath(graph, path, i)) {
                continue;
            }
            visited.add(i);
            path.add(i);
            dfs(i, n, visited, path, cost + graph[city][i], graph, res);
            // 回溯, 移除掉
            visited.remove(i);
            path.remove(path.size() - 1);
        }
    }

    // dfs剪枝
    private boolean hasBetterPath(int[][] graph, List<Integer> path, int city) {
        // 只有确定了最后一个点city后才能判断city前一个路径是否有最优
        // 1-2-3-4-5-6  add7
        // 将city前一个分别和第二个开始的路径替换, 寻找是否有更好的路线
        // 添加了city后的路径1-2 + 2 -6 + 6 - 7
        // 1- 6 6-2 2-7是否比原来更优化
        for (int i = 1; i < path.size(); i++) {
            int a = path.get(i - 1);
            int b = path.get(i);
            int last = path.get(path.size() - 1);
            if (graph[a][b] + graph[last][city] > graph[a][last] + graph[b][city]) {
                return true;
            }
        }
        return false;
    }

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
