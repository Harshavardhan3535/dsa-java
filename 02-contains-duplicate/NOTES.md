# 02 - Contains Duplicate (LeetCode 217)

**HashSet idea:** For each number, ask the set whether I've seen it. If yes, return true. If not, add it and move on. Return false only after the loop ends.

**Sorting idea:** After sorting, equal numbers sit next to each other, so compare each number with the one before it (start i at 1).

| Approach | Time | Extra memory |
|----------|------|--------------|
| Brute force (two loops) | O(n^2) | O(1) |
| Sorting | O(n log n) | O(1) |
| HashSet | O(n) | O(n) |

**Note:** Sorting changes the input array. HashSet trades memory for speed.

**Mistake:** I forgot `seen.add(...)`, so the set stayed empty and the method always returned false.
