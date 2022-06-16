package cloud.lintcode.dfs;

import java.util.*;
//按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord ->
//s1 -> s2 -> ... -> sk 这样的单词序列，并满足： 
//
// 
// 
// 
// 每对相邻的单词之间仅有单个字母不同。 
// 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单
//词。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的
// 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//解释：存在 2 种最短的转换序列：
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：[]
//解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 5 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有单词 互不相同 
// 
// 
// 
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 580 👎 0

public class num126WordLadderIi_bfsDfs {
    public static void main(String[] args) {
        Solution solution = new num126WordLadderIi_bfsDfs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
                return new ArrayList<>();
            }
            if (!wordList.contains(beginWord)) {
                wordList.add(beginWord);
            }
            Map<String, Integer> distance = new HashMap<>();
            Map<String, List<String>> fromToMap = new HashMap<>();
            for (String s : wordList) {
                fromToMap.put(s, new ArrayList<>());
            }
            bfs(fromToMap, distance, beginWord, endWord, wordList);

            List<List<String>> res = new ArrayList<>();
            // 记录当前路径
            List<String> list = new ArrayList<>();
            // 没有到达最后一个词的距离, 直接返回
            if (!distance.containsKey(endWord)) {
                return res;
            }
            dfs(res, list, beginWord, endWord, fromToMap, distance.get(endWord));
            return res;
        }

        private void dfs(List<List<String>> res, List<String> path, String curWord, String endWord, Map<String, List<String>> fromToMap, Integer minLen) {
            // 当前路径已经是所找到的最短路径的长度+ 1了
            if (path.size() == minLen + 1) {
                return;
            }
            path.add(curWord);
            // 到达终点, 记录路径
            if (curWord.equals(endWord)) {
                res.add(new ArrayList<>(path));
            } else {
                // 没有到达, 继续遍历
                for (String nextWord : fromToMap.get(curWord)) {
                    dfs(res, path, nextWord, endWord, fromToMap, minLen);
                }
            }
            path.remove(path.size() - 1);
        }

        private void bfs(Map<String, List<String>> fromToMap, Map<String, Integer> distance, String beginWord, String endWord, List<String> wordList) {
            distance.put(beginWord, 0);
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            while (!q.isEmpty()) {
                String curWord = q.poll();
                for (String nextWord : getNextWords(curWord, wordList)) {
                    // nextWord没有出现过, 或者从起点到达当前点有多条相同长度的路线
                    if (!distance.containsKey(nextWord) || distance.get(nextWord) == (distance.get(curWord) + 1)) {
                        fromToMap.get(curWord).add(nextWord);
                    }
                    // nextWord没有出现过, 放到里面, 记录起点到nextWord的长度
                    if (!distance.containsKey(nextWord)) {
                        distance.put(nextWord, distance.get(curWord) + 1);
                        q.offer(nextWord);
                    }
                }
            }
        }


        private List<String> getNextWords(String word, List<String> wordList) {
            List<String> nextWords = new ArrayList<>();
            for (char c = 'a'; c <= 'z'; c++) {
                for (int i = 0; i < word.length(); i++) {
                    if (c == word.charAt(i)) {
                        continue;
                    }
                    String nextWord = replace(word, i, c);
                    if (wordList.contains(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }
            }
            return nextWords;
        }

        private String replace(String word, int index, char c) {
            char[] chars = word.toCharArray();
            chars[index] = c;
            return new String(chars);
        }

        class Node {
            // 走到当前点的路径
            public List<String> list;
            // 走到当前点的所有经过的点
            public Set<String> set;

            public Node(List<String> list, Set<String> set) {
                this.list = list;
                this.set = set;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}