package cloud.lintcode.bfs;

import java.util.*;
//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> 
//s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 1047 👎 0

public class num127WordLadder_nextLevel {
    public static void main(String[] args) {
        Solution solution = new num127WordLadder_nextLevel().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            visited.add(beginWord);

            // length代表下一层的深度
            int length = 1;
            // 如果可以继续被访问, 那么就变成了环
            while (!queue.isEmpty()) {
                length++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    for (String nextWord : getNextWords(word, wordList)) {
                        if (visited.contains(nextWord)) {
                            continue;
                        }

                        if (nextWord.equals(endWord)) {
                            return length;
                        }

                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
            return 0;
        }

        // 当词短的时候, 这个更快
        // 如果每个单独比较, 那么词越多, 速度越慢
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}