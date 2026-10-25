
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    islands++;

                    // Visit all connected land cells
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // Stop if outside the grid or at water
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid[row][col] == '0') {
            return;
        }

        // Mark this land cell as visited
        grid[row][col] = '0';

        // Explore all four directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}
