package company;


/**
 * @author 王波
 */
public class MinStartValue {
    int[] arr = new int[]{-3, 2, -3, 4, 2};

    public int minStartValue(int[] nums) {
        int min = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.min(pre + num, num);
            min = Math.min(min, pre);
        }
        return 1 - min;
    }

    public void min() {
        System.out.println(new MinStartValue().minStartValue(arr));
    }
}
