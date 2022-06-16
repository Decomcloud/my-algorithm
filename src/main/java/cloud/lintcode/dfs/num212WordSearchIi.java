package cloud.lintcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 672 👎 0

public class num212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new num212WordSearchIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            if (board == null || board.length == 0) {
                return new ArrayList<>();
            }
            if (board[0] == null || board[0].length == 0) {
                return new ArrayList<>();
            }

            boolean[][] visited = new boolean[board.length][board[0].length];
            Set<String> wordSet = new HashSet<>();
            Set<String> prefixSet = new HashSet<>();
            // 构建前缀和词
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    prefixSet.add(word.substring(0, i + 1));
                }
                wordSet.add(word);
            }

            Set<String> resultSet = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    visited[i][j] = true;
                    dfs(board, visited, i, j, String.valueOf(board[i][j]), wordSet, prefixSet, resultSet);
                    visited[i][j] = false;
                }
            }
            return new ArrayList<>(resultSet);
        }

        public int[] dx = new int[]{0, 0, 1, -1};
        public int[] dy = new int[]{1, -1, 0, 0};

        // word记录当前dfs找到的词
        // visited 用于标记走过的点
        private void dfs(char[][] board,
                         boolean[][] visited,
                         int x,
                         int y,
                         String word,
                         Set<String> wordSet,
                         Set<String> prefixSet,
                         Set<String> resultSet) {
            if (!prefixSet.contains(word)) {
                return;
            }

            // 这里不能直接返回, 有可能其他词比该词更长
            if (wordSet.contains(word)) {
                resultSet.add(word);
            }

            for (int i = 0; i < 4; i++) {
                int adjX = x + dx[i];
                int adjY = y + dy[i];
                if (!inside(board, adjX, adjY) || visited[adjX][adjY]) {
                    continue;
                }
                visited[adjX][adjY] = true;
                dfs(board, visited, adjX, adjY, word + board[adjX][adjY], wordSet, prefixSet, resultSet);
                visited[adjX][adjY] = false;
            }
        }

        private boolean inside(char[][] board, int x, int y) {
            return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}