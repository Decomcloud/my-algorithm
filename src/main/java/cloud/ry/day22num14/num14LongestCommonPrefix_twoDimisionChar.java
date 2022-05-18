package cloud.ry.day22num14;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2235 👎 0

public class num14LongestCommonPrefix_twoDimisionChar {
    public static void main(String[] args) {
        Solution solution = new num14LongestCommonPrefix_twoDimisionChar().new Solution();
        //solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs == null || strs.length == 0) {
                return "";
            }
            int numberOfStrings = strs.length;
            char[][] charList = new char[numberOfStrings][];
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String s : strs) {
                charList[i++] = s.toCharArray();
            }
            for (int x = 0; x < charList[0].length; x++) {
                if (ifSameCHarColumn(charList, x, numberOfStrings)) {
                    sb.append(charList[0][x]);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }

        private boolean ifSameCHarColumn(char[][] charList, int columnNumber, int lineNum) {
            // 边界检查, 正常来说这里不会越界
            if (charList[0].length <= columnNumber) {
                return false;
            }
            char c = charList[0][columnNumber];
            for (int i = 1; i < lineNum; i++) {
                // 边界检查, 如果短于长度, 直接返回失败
                if (charList[i].length <= columnNumber) {
                    return false;
                }
                if (charList[i][columnNumber] != c) {
                    return false;
                }
            }
            return true;
        }

        private String twoStringLcp(String first, String sec) {
            char[] firstStr = first.toCharArray();
            char[] secStr = sec.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(firstStr.length, secStr.length); i++) {
                if (firstStr[i] == secStr[i]) {
                    sb.append(firstStr[i]);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}