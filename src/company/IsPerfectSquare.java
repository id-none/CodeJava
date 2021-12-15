package company;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int n = (int) Math.sqrt(num);
        return n * n == num;
    }
}
