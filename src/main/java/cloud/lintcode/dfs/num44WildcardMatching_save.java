package cloud.lintcode.dfs;
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 👍 901 👎 0

public class num44WildcardMatching_save {
    public static void main(String[] args) {
        Solution solution = new num44WildcardMatching_save().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            return dfs(s, 0, p, 0);
        }

        private boolean dfs(String source, int sIndex, String pattern, int pIndex) {
            // string 和 pattern都没有了
            if (pIndex == pattern.length()) {
                return sIndex == source.length();
            }
            // string没有了, pattern如果都是*, 也可以成立
            if (sIndex == source.length()) {
                return allStar(pattern, pIndex);
            }
            char sChar = source.charAt(sIndex);
            char pChar = pattern.charAt(pIndex);
            if (pChar != '*') {
                // pattern字符为 正常字符或者?, 必须匹配才能继续
                return charMatch(sChar, pChar) && dfs(source, sIndex + 1, pattern, pIndex + 1);
            }
            // pattern为*, 可能匹配多个, 匹配0个时, 移除掉*, 需要匹配多个时, 继续保留*
            return dfs(source, sIndex, pattern, pIndex + 1) || dfs(source, sIndex + 1, pattern, pIndex);
        }

        // 字符相同, 或者pattern是?
        private boolean charMatch(char sChar, char pChar) {
            return sChar == pChar || pChar == '?';
        }

        private boolean allStar(String p, int pIndex) {
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}