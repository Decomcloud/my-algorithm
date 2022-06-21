package cloud.lintcode.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1656 👎 0

public class num139WordBreak {
    public static void main(String[] args) {
        Solution solution = new num139WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return true;
            }
            if (wordDict == null || wordDict.size() == 0) {
                return false;
            }

            return dfs(s, 0, getMaxWordLength(wordDict), wordDict, new HashMap<Integer, Boolean>());
        }

        // memo 记录从index到最后是否可以被拆分
        // 从index开始的组合能否划为
        private boolean dfs(String s, int index, int maxWordLength, List<String> dict, Map<Integer, Boolean> memo) {
            if (memo.containsKey(index)) {
                return memo.get(index);
            }

            if (index == s.length()) {
                return true;
            }
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
                if (dfs(s, end, maxWordLength, dict, memo)) {
                    return true;
                }
            }
            memo.put(index, false);
            return false;
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