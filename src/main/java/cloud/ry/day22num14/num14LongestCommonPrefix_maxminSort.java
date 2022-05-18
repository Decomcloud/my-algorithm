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

public class num14LongestCommonPrefix_maxminSort {
    public static void main(String[] args) {
        Solution solution = new num14LongestCommonPrefix_maxminSort().new Solution();
        //solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            char[] first = maxString(strs).toCharArray();
            char[] end = minString(strs).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(first.length, end.length); i++) {
                if (first[i] == end[i]) {
                    sb.append(first[i]);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }


        public String maxString(String[] strs) {
            String maxString;
            if (strs.length > 0) {
                maxString = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    if (ifALargerThanB(strs[i], maxString)) {
                        maxString = strs[i];
                    }
                }
                return maxString;
            }
            return "";
        }

        public String minString(String[] strs) {
            String minString;
            if (strs.length > 0) {
                minString = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    if (ifALargerThanB(minString, strs[i])) {
                        minString = strs[i];
                    }
                }
                return minString;
            }
            return "";
        }

        public boolean ifALargerThanB(String a, String b) {
            char[] aChar = a.toCharArray();
            char[] bChar = b.toCharArray();
            for (int i = 0; i < Math.min(aChar.length, bChar.length); i++) {
                if ((int) aChar[i] > (int) bChar[i]) {
                    return true;
                } else if ((int) aChar[i] < (int) bChar[i]) {
                    return false;
                }
            }

            return a.length() > b.length();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}