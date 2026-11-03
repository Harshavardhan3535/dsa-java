# 13 - Best Time to Buy and Sell Stock (LeetCode 121)

**Idea:** Walk through the days once. Remember the lowest price seen so far (`minPrice`). On each day, the best profit if I sell today is `today's price - minPrice`. Keep the biggest profit seen. If the price only falls, `maxProfit` stays at 0.

**Why one number is enough:** buying must come before selling, and the best day to buy for any selling day is the cheapest day before it. So I only need the minimum so far, not every earlier day. It is the same idea as `leftMax` in Trapping Rain Water, with a minimum.

**Complexity:** O(n) time, O(1) space. Checking every pair of days would be O(n^2).

**Mistakes:**
- I created `buy[i]` and `sell[i]` as arrays, but buy and sell prices are single numbers.
- I subtracted the first price (7) every day, as if the cost never changed. The cost price is the lowest price so far, and it changes.
- I wrote `maxprofit++` and `minprice++` instead of `Math.max` and `Math.min`.
- I put `return maxProfit;` inside the loop, so it returned after the first day (output 0 instead of 5).
- Some "Code Sample" solutions on LeetCode hardcode answers for specific hidden tests. That is cheating, not a real approach, so I ignore them.
