package cloud.ry.day23num20;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3246 👎 0

public class num20ValidParentheses_replaceall {
    public static void main(String[] args) {
        Solution solution = new num20ValidParentheses_replaceall().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            while (s.length() > 0) {
                String s1 = s.replaceAll("\\{\\}", "")
                        .replaceAll("\\[\\]", "")
                        .replaceAll("\\(\\)", "");
                if (s1.length() == s.length()) {
                    break;
                } else {
                    s = s1;
                }
            }
            return !(s.length() > 0);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}