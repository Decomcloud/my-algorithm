package cloud.lintcode.template;

import java.util.*;

/**
 * @author Yunfeng Sun
 * @date 2022/6/9 21:00
 */
public class Bfs {

    // N个点, M条边
    // time O(m + n) 或者Om
    // M最大为n*n,最坏可能为On*n
    public void bfs() {
        Deque<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Integer> distance = new HashMap<>();

        // Step 1: 初始化
        // 把初始化节点放到queue中去, 如果有多个就都放进去
        // 并且标记初始距离为0, 记录在distance map里
        // distance有2个作用, 1. 判断是否已经访问过 2. 记录起点距离
        TreeNode treeNode = new TreeNode();
        queue.offer(treeNode);
        distance.put(treeNode, 0);

        // step2: 不断访问队列

        // 1.不分层
        // while循环 + 每次pop队列中一个点出来
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // step3: 扩展相邻的节点, pop出的节点的相邻节点, 加入队列并在distance中存储距离
            for (TreeNode neighbor : node.neighbors) {
                if (distance.containsKey(neighbor)) {
                    continue;
                }
                distance.put(neighbor, distance.get(node) + 1);
                queue.offer(neighbor);
            }
        }

        // 2.分层遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 取出当前层的所有数据
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // step3: 扩展相邻的节点, pop出的节点的相邻节点, 加入队列并在distance中存储距离
                for (TreeNode neighbor : node.neighbors) {
                    if (distance.containsKey(neighbor)) {
                        continue;
                    }
                    distance.put(neighbor, distance.get(node) + 1);
                    queue.offer(neighbor);
                }
            }

        }
    }

    public class TreeNode {
        public int val;
        public List<TreeNode> neighbors;

        public TreeNode() {
        }
    }

}
