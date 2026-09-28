class Solution {
    public int maxProduct(String[] words) {
        int m = words.length;
        int[] masks = new int[m], lengths = new int[m];

        for (int i = 0; i < m; i++) {
            String str = words[i];
            int mask = 0, len = str.length();

            for (char c : str.toCharArray()) mask |= (1 << (c - 'a'));

            masks[i] = mask;
            lengths[i] = len;
        } 

        int mx = 0;
        for (int i = 0; i < m - 1; i++) {
            int f = masks[i], g = lengths[i];
            for (int j = i + 1; j < m; j++) {
                if ((f & masks[j]) == 0) {
                    int prod = g * lengths[j];

                    if (prod > mx) mx = prod;
                }
            }
        }

        return mx;
    }
}