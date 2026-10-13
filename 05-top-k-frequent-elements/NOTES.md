# 05 - Top K Frequent Elements (LeetCode 347)

**Idea:** Count how often each number appears (key = number, value = count). Put the distinct numbers in a list, sort the list by count with the biggest first, and take the first k numbers.

**Steps:**
1. Tally loop: `count.put(x, count.getOrDefault(x, 0) + 1)`.
2. `keys` = list of the distinct numbers (`count.keySet()`).
3. Sort `keys` by count, descending: `count.get(b) - count.get(a)`.
4. Copy the first k numbers from `keys` into `result` (`j` from 0, `j < k`).

**Complexity:** O(n + m log m) time, where n = array length and m = number of distinct numbers (the sort). O(m) space for the map and the list. There is also an O(n) approach with bucket sort that I can learn later.

**Mistakes:**
- I planned to remove duplicates, but that throws away the counts, and counts are what the problem needs.
- I started the fill loop at `j = 1`, so `result[0]` stayed 0 and the output was `[0,2]`. Positions start at 0.
- I almost wrote `j <= k`, which goes past the last slot. For k items starting from 0, use `<`.
