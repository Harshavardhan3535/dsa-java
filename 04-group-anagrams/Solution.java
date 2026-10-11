import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // HashMap: key = sorted word, value = list of original words
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ga = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!ga.containsKey(key)) {
                ga.put(key, new ArrayList<>());
            }
            ga.get(key).add(word);
        }
        return new ArrayList<>(ga.values());
    }
}
