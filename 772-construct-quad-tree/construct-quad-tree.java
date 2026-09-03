class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int r, int c, int size) {

        // Check whether all values are same
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != grid[r][c]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // If all values are same, create leaf
        if (same) {
            return new Node(grid[r][c] == 1, true);
        }

        // Divide into 4 parts
        int half = size / 2;

        Node topLeft = solve(grid, r, c, half);
        Node topRight = solve(grid, r, c + half, half);
        Node bottomLeft = solve(grid, r + half, c, half);
        Node bottomRight = solve(grid, r + half, c + half, half);

        return new Node(true, false,
                topLeft, topRight,
                bottomLeft, bottomRight);
    }
}