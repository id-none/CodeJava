package company;

public class Matrix {
    int[][] matrix;

    public Matrix(int m, int n) {
        matrix = new int[m][n];
    }

    public int[] flip() {
        int m = (int) (Math.random() * (matrix[0].length - 1));
        int n = (int) (Math.random() * (matrix.length - 1));
        return new int[]{m, n};
    }

    public void reset() {
        int[][] ne = new int[matrix[0].length][matrix.length];
        matrix = ne;
    }
}
