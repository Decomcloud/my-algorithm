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

public class num14LongestCommonPrefix_recursion {
    public static void main(String[] args) {
        Solution solution = new num14LongestCommonPrefix_recursion().new Solution();
        //solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            return divide(strs, 0, strs.length - 1);
        }

        private String divide(String[] strs, int start, int end) {
            if (end == start) {
                return strs[start];
            }
            if (end - start == 1) {
                return twoStringLcp(strs[start], strs[end]);
            }
            int mid = (end + start) / 2;
            String leftLcp = divide(strs, start, mid);
            String rightLcp = divide(strs, mid + 1, end);
            return twoStringLcp(leftLcp, rightLcp);
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