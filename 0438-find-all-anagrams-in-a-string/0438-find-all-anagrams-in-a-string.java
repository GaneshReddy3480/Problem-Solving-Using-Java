import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = 0;
        int required = p.length();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (count[c - 'a'] > 0) {
                required--;
            }

            count[c - 'a']--;
            right++;

            if (right - left > p.length()) {
                char old = s.charAt(left);

                if (count[old - 'a'] >= 0) {
                    required++;
                }

                count[old - 'a']++;
                left++;
            }

            if (required == 0) {
                result.add(left);
            }
        }

        return result;
    }
}