import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Store reversed words
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            map.put(rev, i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();

            for (int j = 0; j <= n; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // left is palindrome
                if (isPalindrome(left)) {
                    Integer index = map.get(right);

                    if (index != null && index != i) {
                        ans.add(Arrays.asList(index, i));
                    }
                }

                // right is palindrome
                if (j != n && isPalindrome(right)) {
                    Integer index = map.get(left);

                    if (index != null && index != i) {
                        ans.add(Arrays.asList(i, index));
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}