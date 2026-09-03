import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Store the first occurrence
            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            // Count frequency
            count.put(num, count.getOrDefault(num, 0) + 1);

            // Update degree
            degree = Math.max(degree, count.get(num));
        }

        // Find shortest subarray for elements with maximum frequency
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = nums.length - first.get(num);
                
                // Find last occurrence
                for (int i = nums.length - 1; i >= first.get(num); i--) {
                    if (nums[i] == num) {
                        length = i - first.get(num) + 1;
                        break;
                    }
                }

                answer = Math.min(answer, length);
            }
        }

        return answer;
    }
}