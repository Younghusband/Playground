package com.yangfan.leetcode.datastructures.strings;


/**
 * 2243. Calculate Digit Sum of a String
 * 计算字符串的数字和
 *
 *
 * 示例 1：
 * 输入：s = "11111222223", k = 3
 * 输出："135"
 * 解释：
 * - 第一轮，将 s 分成："111"、"112"、"222" 和 "23" 。
 *   接着，计算每一组的数字和：1 + 1 + 1 = 3、1 + 1 + 2 = 4、2 + 2 + 2 = 6 和 2 + 3 = 5 。
 *   这样，s 在第一轮之后变成 "3" + "4" + "6" + "5" = "3465" 。
 * - 第二轮，将 s 分成："346" 和 "5" 。
 *   接着，计算每一组的数字和：3 + 4 + 6 = 13 、5 = 5 。
 *   这样，s 在第二轮之后变成 "13" + "5" = "135" 。
 * 现在，s.length <= k ，所以返回 "135" 作为答案。
 *
 */
public class Calculate_Digit_Sum_of_a_String {

    /**
     * 非递归方法
     */
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int sum = 0;
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += s.charAt(j) - '0'; // 直接计算字符代表的数字，避免重复转换
                }
                sb.append(sum); // 一次性添加转换后的字符串
                i += k;
            }
            s = sb.toString(); // 更新字符串为新的累加结果，准备下一轮处理
        }
        return s;
    }

    /**
     * 我的递归方法
     */
    public String my(String s, int k) {
        if (s.length() <= k) return s;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';  // 累加当前字符代表的数字
            // 凑满了，或者到末尾了
            if ((i % k == k - 1) || i == s.length() - 1) {
                sb.append(sum);  // 添加累计的和到StringBuilder
                sum = 0;  // 重置sum
            }
        }
        return digitSum(sb.toString(), k);  // 递归处理下一层
    }

}
