package cloud.ry.day23num20;

import java.util.Stack;
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

public class num20ValidParentheses_stack {
    public static void main(String[] args) {
        Solution solution = new num20ValidParentheses_stack().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.equals("")) {
                return true;
            }
            String start = "([{";
            char[] array = s.toCharArray();
            Stack<String> stack = new Stack<>();
            for (char c : array) {
                if (start.contains(String.valueOf(c))) {
                    stack.push(String.valueOf(c));
                } else {
                    if (stack.empty()) {
                        return false;
                    }
                    String pop = stack.pop();
                    if (!match(pop, String.valueOf(c))) {
                        return false;
                    }
                }
            }
            return stack.empty();
        }

        private boolean match(String start, String end) {
            return "(".equals(start) && ")".equals(end) ||
                    "[".equals(start) && "]".equals(end) || "{".equals(start) && "}".equals(end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}