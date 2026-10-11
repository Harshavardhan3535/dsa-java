# 04 - Group Anagrams (LeetCode 49)

**Idea:** Anagrams become the same word when their letters are sorted (eat, tea, ate -> aet). So the sorted word is the group label. Key = sorted word, value = list of the original words with that label. After the loop, return all the lists.

**Steps for each word:**
1. Sort its letters to build the key.
2. If the map has no list for that key yet, create an empty one.
3. Add the original word to that list.

**Complexity:** O(n * k log k) time, where n = number of words and k = longest word length (sorting each word). O(n * k) space for the map.

**Mistakes:**
- I first planned to compare every word with every other word. A map keyed by the sorted word avoids that.
- I wrote `Char` instead of `char`, which gave a compile error. Java is case-sensitive.
- I forgot that `put(key, new ArrayList<>())` must be inside the `if`, otherwise it would wipe the existing group every time.
