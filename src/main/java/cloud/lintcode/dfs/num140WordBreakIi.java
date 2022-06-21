package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
////给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这
//些可
////能的句子。 
////
//// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
////输出:["cats and dog","cat sand dog"]
//// 
////
//// 示例 2： 
////
//// 
////输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
////"pineapple"]
////输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
////解释: 注意你可以重复使用字典中的单词。
//// 
////
//// 示例 3： 
////
//// 
////输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
////输出:[]
//// 
////
//// 
////
//// 提示： 
////
//// 
////
//// 
//// 1 <= s.length <= 20 
//// 1 <= wordDict.length <= 1000 
//// 1 <= wordDict[i].length <= 10 
//// s 和 wordDict[i] 仅有小写英文字母组成 
//// wordDict 中所有字符串都 不同 
//// 
//// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 👍 605 👎 0
//

public class num140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new num140WordBreakIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
                return new ArrayList<>();
            }
            List<String> results = new ArrayList<>();
            dfs(s, 0, getMaxWordLength(wordDict), wordDict, new HashMap<Integer, Boolean>(), new ArrayList<String>(), results);
            return results;
        }

        private void dfs(String s, int index, int maxWordLength, List<String> wordDict, Map<Integer, Boolean> memo, List<String> used, List<String> results) {
            if (index == s.length()) {
                results.add(join(" ", used));
            }
            if (!isPossible(s, index, maxWordLength, wordDict, memo)) {
                return;
            }
            for (int end = index + 1; end <= s.length(); end++) {
                if (end - index > maxWordLength) {
                    break;
                }
                String word = s.substring(index, end);
                if (!wordDict.contains(word)) {
                    continue;
                }
                used.add(word);
                dfs(s, index + word.length(), maxWordLength, wordDict, memo, used, results);
                used.remove(used.size() - 1);
            }
        }

        // 是否有可以拆解的
        private boolean isPossible(String s, int index, int maxWordLength, List<String> wordDict, Map<Integer, Boolean> memo) {
            if (memo.containsKey(index)) {
                return memo.get(index);
            }
            if (index == s.length()) {
                return true;
            }
            for (int end = index + 1; end <= s.length(); end++) {
                if (end - index > maxWordLength) {
                    break;
                }
                String word = s.substring(index, end);
                if (!wordDict.contains(word)) {
                    continue;
                }
                // 特别记录, 找到后还要继续找
                if (isPossible(s, end, maxWordLength, wordDict, memo)) {
                    memo.put(index, true);
                    return true;
                }
            }
            memo.put(index, false);
            return false;
        }

        private String join(String s, List<String> used) {
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            for (String word : used) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append(s);
                }
                sb.append(word);
            }
            return sb.toString();
        }

        private int getMaxWordLength(List<String> wordDict) {
            int maxWordLength = 0;
            for (String word : wordDict) {
                maxWordLength = Math.max(maxWordLength, word.length());
            }
            return maxWordLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}