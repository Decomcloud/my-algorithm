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

public class num14LongestCommonPrefix_simple {
    public static void main(String[] args) {
        Solution solution = new num14LongestCommonPrefix_simple().new Solution();
        //solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            String first, sec;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length - 1; i++) {

                first = strs[i];
                sec = strs[i + 1];
                if (first.length() == 0 || sec.length() == 0) {
                    return "";
                }
                min = Math.min(min, getMin(first, sec));
                System.out.println(min);
            }
            return strs[0].substring(0, min);
        }

        private int getMin(String first, String sec) {
            int min = 0;
            for (int i = 0; i < first.length(); i++) {
                if (sec.length() <= i) {
                    return min;
                }
                if (first.charAt(i) != sec.charAt(i)) {
                    break;
                }
                min++;
            }
            return min;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}