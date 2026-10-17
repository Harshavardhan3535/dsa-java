# 07 - Longest Consecutive Sequence (LeetCode 128)

**Idea:** Put all numbers in a HashSet. A number is the start of a run if `num - 1` is not in the set. From each start, keep checking `current + 1` and count the streak. Keep the longest streak.

**Why two loops:** The first loop must finish filling the set before the second loop asks about neighbours, because a neighbour can sit later in the array. The second loop runs over the set so duplicates are not counted twice.

**Complexity:** O(n) time, since every number is walked over only once, by the run it belongs to. O(n) space for the set. Sorting would be O(n log n), so it does not meet the O(n) requirement.

**Mistakes:**
- I thought sorting was enough, but it is O(n log n) and duplicates need extra care.
- I wrote 100 and 200 as a run, but consecutive means each number is exactly 1 more.
- I wrote `set.add(1)` instead of `set.add(x)`, so the set only held one number.
- I forgot `streak++` inside the `while`, so the length never grew.

## Approach 2: Sorting (O(n log n))
Sort the array, then compare each number with the next one:
- next is exactly +1: the streak grows, and I update the longest
- next is equal (duplicate): ignore it, the streak does not change
- anything else: the run is broken, so the streak resets to 1

| Approach | Time | Extra memory | Changes input |
|----------|------|--------------|---------------|
| HashSet | O(n) | O(n) | No |
| Sorting | O(n log n) | O(1) to O(n) | Yes |

The problem asks for O(n), so HashSet is the intended answer. Sorting is a good first answer in an interview before improving it.
