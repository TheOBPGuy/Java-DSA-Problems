import java.util.*;


public class WordSearch {

    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     * 
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches then we need to also recursively check if we are finding
                // matches for the remaining characters of the word
                if (board[i][i] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int count, String word) {
        // Base Condition for Negative Case
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        // Base Condition for Positive case:
        if (count == word.length()) {
            return true;
        }

        // Recursive calls using DFS:
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+i, j, count+1, word) ||
                dfs(board, i-i, j, count+1, word) ||
                dfs(board, i, j+1, count+1, word) ||
                dfs(board, i, j-1, count+1, word);
        // Return the "replaced" board character back to its original value:
        board[i][j] = temp;
        return found;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,0,1};
        // System.out.println(missingNumber(nums));
    }
}
