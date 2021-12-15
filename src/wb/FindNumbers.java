package wb;

/**
 * @author 王波
 */
public class FindNumbers {
    int findNumbers(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            if ((num + "").length() % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }
}
