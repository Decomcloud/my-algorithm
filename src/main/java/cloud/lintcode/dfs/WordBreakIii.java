package cloud.lintcode.dfs;

import java.util.*;
//给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回数量。
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 回溯 👍 605 👎 0

public class WordBreakIii {
    public static void main(String[] args) {
        Solution solution = new WordBreakIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (wordDict == null || wordDict.size() == 0) {
                return 0;
            }
            Set<String> lowerDict = new HashSet<>();
            int maxLength = getMaxWordLength(wordDict, lowerDict);
            return dfs(s.toLowerCase(), 0, maxLength, lowerDict, new HashMap<Integer, Integer>());
        }

        // memo 记录从index到最后是否可以被拆分
        // 从index开始的组合能否划为
        private int dfs(String s, int index, int maxWordLength, Set<String> dict, Map<Integer, Integer> memo) {
            if (memo.containsKey(index)) {
                return memo.get(index);
            }

            if (index == s.length()) {
                return 1;
            }
            int result = 0;

            for (int end = index + 1; end <= Math.min(s.length(), index + maxWordLength); end++) {
                // 分解出的前缀词大于最大词的长度, 肯定不在dict中, 那么后面更长的也不在, 直接退出
                //if (end - index > maxWordLength) {
                //	break;
                //}
                String word = s.substring(index, end);
                // 前缀词在不在dict中
                if (!dict.contains(word)) {
                    continue;
                }
                // 前缀词在不在dict中, 分离出前缀词,继续查找后面的
                result += dfs(s, end, maxWordLength, dict, memo);

            }
            memo.put(index, result);
            return result;
        }

        private int getMaxWordLength(List<String> wordDict, Set<String> lowerDict) {
            int maxWordLength = 0;
            for (String word : wordDict) {
                lowerDict.add(word.toLowerCase());
                maxWordLength = Math.max(maxWordLength, word.length());
            }
            return maxWordLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}