package com.yangfan.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class SumTo100 {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        // 开始寻找符合条件的表达式，初始表达式为空，从数字 1 开始
        findCombinations(results, "", 1, 0, 0);
        for (String result : results) {
            System.out.println(result + " = 100");
        }
    }

    private static void findCombinations(List<String> results, String expression, int nextNumber, int currentValue, int lastValue) {
        // 如果已经处理完所有数字
        if (nextNumber > 9) {
            // 如果当前表达式的值等于 100，则将其添加到结果列表中
            if (currentValue + lastValue == 100) {
                results.add(expression);
            }
            return;
        }
        // 尝试加法：将当前数字加到表达式中
        findCombinations(results,
                expression + "+" + nextNumber,
                nextNumber + 1, currentValue + lastValue, nextNumber);
        // 尝试减法：将当前数字以减号连接到表达式中
        findCombinations(results,
                expression + "-" + nextNumber,
                nextNumber + 1, currentValue + lastValue, -nextNumber);
        // 尝试连接数字：将当前数字连接到上一个数字后面
        if(expression != null && !expression.equals("")) {
            findCombinations(results,
                    expression + nextNumber,
                    nextNumber + 1, currentValue,
                    lastValue * 10 + (lastValue > 0 ? nextNumber : -nextNumber));
        }
    }

}
