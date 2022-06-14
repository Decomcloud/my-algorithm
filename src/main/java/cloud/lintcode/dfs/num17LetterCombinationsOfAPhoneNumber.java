package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1956 👎 0

public class num17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new num17LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return res;
            }
            dfs(digits, 0, "", res);
            return res;
        }

        // index 遍历数字的index
        private void dfs(String digits, int index, String combination, List<String> res) {
            if (index == digits.length()) {
                res.add(combination);
                return;
            }
            int digit = digits.charAt(index) - '0';
            // 当前数字对应的字母
            // 下一个组合为全部的字母, 前面的顺序并不影响当前顺序, 所以从0开始
            for (int i = 0; i < KEYBOARD[digit].length(); i++) {
                // index + 1, 遍历下一个数字
                // combination 拼接上当前的字母
                dfs(digits, index + 1, combination + KEYBOARD[digit].charAt(i), res);
            }
        }

        public final String[] KEYBOARD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
//leetcode submit region end(Prohibit modification and deletion)

}