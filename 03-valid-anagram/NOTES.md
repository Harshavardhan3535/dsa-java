# 03 - Valid Anagram (LeetCode 242)

**Sorting idea:** Two strings are anagrams if they have the same letters. Convert both to char arrays, sort them, and compare. Check the lengths first, since different lengths can never be anagrams.

**HashMap idea:** Count how many times each character appears in each string (character = key, count = value). Anagrams have equal count tables, so compare the two maps.

| Approach | Time | Extra memory |
|----------|------|--------------|
| Sorting | O(n log n) | O(n) for the char arrays |
| HashMap count | O(n) | O(k), k = distinct characters |

**Note:** `getOrDefault(ch, 0)` returns 0 for a character not in the map yet, so the first count becomes 1 without a null error.

**Mistakes:**
- I thought equal length alone meant anagram. It is only the first check.
- I wrote `Array.equals` instead of `Arrays.equals`.
- I put a `;` after the `if` condition, which ended the if early.
