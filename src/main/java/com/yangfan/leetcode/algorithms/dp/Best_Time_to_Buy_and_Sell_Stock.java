package com.yangfan.leetcode.algorithms.dp;

/**
 * 121. Best Time to Buy and Sell Stock
 * 买卖股票的最佳时机
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class Best_Time_to_Buy_and_Sell_Stock {

    /**
     * 我们只需要遍历价格数组一遍，记录历史最低点，
     * 然后在每一天考虑这么一个问题：
     * 如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
     * 当考虑完所有天数之时，我们就得到了最好的答案。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minIndex = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] <= prices[minIndex])
                minIndex = i;
            else
                profit = Math.max(prices[i] - prices[minIndex], profit);
        }
        return profit;
    }

    /**
     * 更直观
     */
    public int maxProfit1(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

}
