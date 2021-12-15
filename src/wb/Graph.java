package wb;

public class Graph {
    private int vex;
    private final int[][] arcs = new int[vex+1][vex+1];

    public Graph() {

    }

    public Graph(int v, int[][] m) {
        this.vex = v;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                this.arcs[i][j] = m[i][j];
            }
        }
    }

    public int getVex() {
        return this.vex;
    }

    public void setVex(int v) {
        this.vex = v;
    }

    public int get_arcs(int i, int j) {
        return arcs[i][j];
    }

    public void setArcs(int[][] m) {
        for (int i = 0; i < vex; i++) {
            for (int j = 0; j < vex; j++) {
                this.arcs[i][j] = m[i][j];
            }
        }
    }
}
