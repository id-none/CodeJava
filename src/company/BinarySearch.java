package company;

public class BinarySearch {
    public int binarySearch(int[] list, int k, int lo, int hi) {
        if(lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (k == list[mid]) {
            return mid;
        } else if (k > list[mid]) {
            return binarySearch(list, k, mid + 1, hi);
        } else {
            return binarySearch(list, k, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] ans = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16};
        System.out.println(new BinarySearch().binarySearch(ans, 19, 0, ans.length - 1));
    }
}
