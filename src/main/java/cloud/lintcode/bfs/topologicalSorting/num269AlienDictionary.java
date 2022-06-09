package cloud.lintcode.bfs.topologicalSorting;

import java.util.*;
//现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。 
//
// 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 230 👎 0

public class num269AlienDictionary {
    public static void main(String[] args) {
        Solution solution = new num269AlienDictionary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = construceGraph(words);
            if (graph == null) {
                return "";
            }
            return topologicalSorting(graph);
        }

        private String topologicalSorting(Map<Character, Set<Character>> graph) {
            // 统计每个点前面排序的字母数量
            Map<Character, Integer> indegree = new HashMap<>();
            for (Character c : graph.keySet()) {
                indegree.put(c, 0);
            }

            for (Character c : graph.keySet()) {
                for (Character v : graph.get(c)) {
                    // 所有邻居的深度 + 1
                    indegree.put(v, indegree.get(v) + 1);
                }
            }
            // 要求有多个字母时, 返回有效字母顺序
            // PriorityQueue, 当有多个字母时, 会返回比较小的
            Queue<Character> queue = new PriorityQueue<>();
            for (Character c : indegree.keySet()) {
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {
                Character head = queue.poll();
                sb.append(head);
                for (Character neighbor : graph.get(head)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            // 如果有些字母美哦与出现在里面, 那么就没有答案
            return sb.length() == indegree.size() ? sb.toString() : "";
        }

        private Map<Character, Set<Character>> construceGraph(String[] words) {
            // key 字母 value, 顺序在后面的字母
            Map<Character, Set<Character>> graph = new HashMap<>();
            // init
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    char c = words[i].charAt(j);
                    if (!graph.containsKey(c)) {
                        graph.put(c, new HashSet<>());
                    }
                }
            }

            // 建立相关连接
            for (int i = 0; i < words.length - 1; i++) {
                int index = 0;
                while (index < words[i].length() && index < words[i + 1].length()) {
                    if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                        graph.get(words[i].charAt(index)).add(words[i + 1].charAt(index));
                        break;
                    }
                    index++;
                }

                // ["abc", "ab"] 这样不合法, 直接返回null
                if (index == Math.min(words[i].length(), words[i + 1].length())) {
                    if (words[i].length() > words[i + 1].length()) {
                        return null;
                    }
                }
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}