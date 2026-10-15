# 06 - Product of Array Except Self (LeetCode 238)

**Idea:** The answer at position i is (product of everything left of i) x (product of everything right of i). No division is needed.

**Two passes:**
1. Left to right: store the running left product in `result[i]` first, then multiply `left` by `nums[i]`. An empty side is 1 (not 0), so the edges need no special case.
2. Right to left: multiply `result[i]` by the running `right` product first, then multiply `right` by `nums[i]`.

**Why the order matters:** The value at i must not include `nums[i]` itself, so I use the running product first and update it afterwards.

**Complexity:** O(n) time (two loops, one after the other). O(1) extra space, because the output array does not count.

**Mistakes:**
- I started with a separate case for each index. One loop works for any length.
- I wrote `int left[] = 1;` but `left` is a single number, not an array.
- I forgot `result[i] = result[i] * right;` in the second loop, so only the left products were returned.
