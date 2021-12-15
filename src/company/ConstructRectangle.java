package company;

public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        double x, y = 0, i = 0;
        x = Math.sqrt(area);
        for (i = (int) x + 1; i >= 1; i--) {
            y = area / i;
            if ((int) y + y == 2 * y) {
                break;
            }
        }
        int[] a = new int[2];
        a[0] = (int) y;
        a[1] = (int) i;
        return a;
    }
}
