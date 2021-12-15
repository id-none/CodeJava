package wb;

/**
 * @author 王波
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[][] min = new int[n][n];
        int[] hang = new int[n];
        int[] lie = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hang[i] = Math.max(hang[i], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lie[i] = Math.max(lie[i], grid[j][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min[i][j] = Math.min(hang[i], lie[j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += min[i][j] - grid[i][j];
            }
        }
        return sum;
    }
}
