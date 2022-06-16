package cloud.lintcode.dfs;
//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 567 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new Offer38ZiFuChuanDePaiLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            List<String> permutations = new ArrayList<>();
            // 题目中length >= 1
            // s可能包含重复字符串, 所以需要先排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder permutation = new StringBuilder();
            boolean[] visited = new boolean[chars.length];
            dfs(chars, visited, permutation, permutations);
            String[] res = new String[permutations.size()];
            int i = 0;
            for (String tmp : permutations) {
                res[i++] = tmp;
            }
            return res;
        }

        private void dfs(char[] chars, boolean[] visited, StringBuilder permutation, List<String> permutations) {
            if (permutation.length() == chars.length) {
                permutations.add(permutation.toString());
                return;
            }

            for (int i = 0; i < chars.length; i++) {
                // 如果已经访问过了, 继续下一个
                if (visited[i]) {
                    continue;
                }
                // a' a'' b
                // a' a'' b 可以
                // a'' a' b 不可以
                // 在前面的a'使用之前, 不能使用a''
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                permutation.append(chars[i]);
                dfs(chars, visited, permutation, permutations);
                // 回溯
                permutation.deleteCharAt(permutation.length() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}