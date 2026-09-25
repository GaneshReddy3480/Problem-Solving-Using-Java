import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = pattern.charAt(i);

            if (map1.containsKey(a) && map1.get(a) != b) {
                return false;
            }

            if (map2.containsKey(b) && map2.get(b) != a) {
                return false;
            }

            map1.put(a, b);
            map2.put(b, a);
        }

        return true;
    }
}