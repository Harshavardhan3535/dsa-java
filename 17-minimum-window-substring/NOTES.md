# 17 - Minimum Window Substring (LeetCode 76)

**Idea:** Slide a window over `s`. Move `right` forward until the window contains every letter of `t` (with the right counts), then move `left` forward to shrink it while it stays valid, and remember the smallest valid window.

**The shopping list:** `need[ch]` is how many more copies of `ch` the window still needs. It starts from the counts in `t`.
- A letter entering: if `need[ch] > 0` before the change, a really needed letter arrived, so `missing--`. Then always `need[ch]--`. A negative value means extra copies.
- A letter leaving: `need[ch]++`. If the value is now above 0, a needed letter left, so `missing++` and the window is invalid.
- `missing` starts at `t.length()`. The window is valid when `missing == 0`.

**Duplicates:** they are counted, not removed. Extras give negative counts, which is what lets the window shrink without losing a needed letter.

**Result:** keep `bestStart` and `bestLen`. If no valid window was ever found (for example `s = "a"`, `t = "aa"`), return `""`.

**Complexity:** O(m + n) time, because each end of the window moves forward at most m times. O(1) space (an array of 128).

**Mistakes:**
- I thought `right` should move when the window is valid. It is `left` that moves then, to shrink it. `right` moves when letters are missing.
- I used an `int minWindow` for the answer, but a substring needs a start and a length.
- I wrote `if (need > 0)` without the index. It must be `need[c]`.
- I thought "no letters of `t` found" gives `""`, but the real rule is "no valid window was ever found".
- I was confused by negative counts. They mean extra copies of a letter, not a mistake.
