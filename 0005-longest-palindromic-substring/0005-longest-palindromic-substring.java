class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        StringBuilder t = new StringBuilder();

        t.append('^');

        for (int i = 0; i < s.length(); i++) {
            t.append('#');
            t.append(s.charAt(i));
        }

        t.append("#$");

        int n = t.length();
        int[] p = new int[n];

        int center = 0;
        int right = 0;

        int maxLen = 0;
        int maxCenter = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (t.charAt(i + 1 + p[i]) ==
                   t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLen) / 2;

        return s.substring(start, start + maxLen);
    }
}