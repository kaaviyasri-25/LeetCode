class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        
        int targetSum = sum / k;
        Arrays.sort(nums);
        // add a reverse it helps!
        return backtrack(nums.length - 1, nums, new int[k], targetSum);
    }
    
    private boolean backtrack(int index, int[] nums, int[] sums, int targetSum) {
        if (index < 0) return true;
        
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > targetSum) continue;
            
            sums[i] += nums[index];
            
            if (backtrack(index - 1, nums, sums, targetSum)) {
                return true;
            }
            
            sums[i] -= nums[index];
            
            if (sums[i] == 0) break;// why ? explanation given below
        }
        
        return false;
    }
}