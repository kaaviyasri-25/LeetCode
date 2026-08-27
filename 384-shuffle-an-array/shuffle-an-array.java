import java.util.*;

class Solution {

    private int[] original;
    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        original = nums.clone();
        this.nums = nums.clone();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        nums = original.clone();

        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}