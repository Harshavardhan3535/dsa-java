import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // Approach 1: Sorting - O(n log n) time
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Approach 2: HashMap character count - O(n) time, O(k) space
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sc = new HashMap<>();
        Map<Character, Integer> tc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            sc.put(a, sc.getOrDefault(a, 0) + 1);
            tc.put(b, tc.getOrDefault(b, 0) + 1);
        }
        return sc.equals(tc);
    }
}
