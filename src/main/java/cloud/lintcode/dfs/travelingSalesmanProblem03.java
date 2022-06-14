package cloud.lintcode.dfs;

import java.util.Random;

/**
 * @author Yunfeng Sun
 * @date 2022/6/14 0:44
 */
public class travelingSalesmanProblem03 {

    // https://www.lintcode.com/problem/816/description

    public int RANDOM_TIMES = 1000;
    public Random rand = new Random(1000);

    public int minCost(int n, int[][] roads) {
        int[][] graph = constructGraph(roads, n);
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < RANDOM_TIMES; i++) {
            int[] path = getRandomPath(n);
            int cost = adjustPath(path, graph);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private int adjustPath(int[] path, int[][] graph) {
        boolean adjusted = true;
        int n = path.length;
        while (adjusted) {
            adjusted = false;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (canSwap(path, i, j, graph)) {
                        int tmp = path[i];
                        path[i] = path[j];
                        path[j] = tmp;
                        adjusted = true;
                    }
                }
            }
        }

        int cost = 0;
        for (int i = 1; i < n; i++) {
            cost += graph[path[i - 1]][path[i]];
        }
        return cost;
    }

    private boolean canSwap(int[] path, int i, int j, int[][] graph) {
        int before = adjcentCost(path, i, path[i], graph);
        before += adjcentCost(path, j, path[j], graph);
        int after = adjcentCost(path, i, path[j], graph);
        after += adjcentCost(path, j, path[i], graph);
        return before > after;
    }

    private int adjcentCost(int[] path, int i, int city, int[][] graph) {
        int cost = graph[path[i - 1]][city];
        if (i + 1 < path.length) {
            cost += graph[city][path[i + 1]];
        }
        return cost;
    }


    private int[] getRandomPath(int n) {
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化路径
            path[i] = i + 1;
        }
        for (int i = 2; i < n; i++) {
            // [0, i) - > [1, i]
            // 每个都随机交换
            int j = (rand.nextInt(1000) % i) + 1;
            int tmp = path[i];
            path[i] = path[j];
            path[j] = tmp;
        }
        return path;
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
