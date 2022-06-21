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

// 131
public class num140WordBreakIi_store {
    public static void main(String[] args) {
        Solution solution = new num140WordBreakIi_store().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
                return new ArrayList<>();
            }
            // map, 记录string value为其分割方案
            return dfs(s, getMaxWordLength(wordDict), wordDict, new HashMap<String, List<String>>());
        }

        private List<String> dfs(String s, int maxWordLength, List<String> wordDict, Map<String, List<String>> memo) {
            // 分割记录中包含s, 直接返回
            if (memo.containsKey(s)) {
                return memo.get(s);
            }
            List<String> results = new ArrayList<>();

            for (int prefixLen = 1; prefixLen < s.length(); prefixLen++) {
                if (prefixLen > maxWordLength) {
                    break;
                }
                // 找出前缀
                String word = s.substring(0, prefixLen);
                if (!wordDict.contains(word)) {
                    continue;
                }
                // prefix在词典中, 继续找后面的
                String suffix = s.substring(prefixLen);
                List<String> segmentations = dfs(suffix, maxWordLength, wordDict, memo);
                // 将后缀分割出的结果 前面拼接上word
                for (String segmentation : segmentations) {
                    results.add(word + " " + segmentation);
                }
            }
            // 前面无法判断s是否在词典中, 这里单独判断
            if (wordDict.contains(s)) {
                results.add(s);
            }
            memo.put(s, results);
            return results;
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