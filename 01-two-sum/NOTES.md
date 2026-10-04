# 01 - Two Sum (LeetCode 1)

**Idea:** At each number, work out the partner needed (`target - nums[i]`) and check whether I've already seen it. If yes, return both positions. If not, remember the current number and move on.

**HashMap:** key = number, value = its index. The index is the value because the answer needs positions, not numbers.

**Complexity:** O(n) time, since one pass and each map lookup is instant. O(n) space for the map. Brute force was O(n²).

**Mistake:** I left a second `j` loop from the brute-force version inside the HashMap solution, and it failed the test cases. The HashMap approach needs only one loop.