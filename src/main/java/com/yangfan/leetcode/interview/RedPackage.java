package com.yangfan.leetcode.interview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 抢红包算法
 *
 * 已知：1.总金额n元，2.需要分成x份
 *      * 要求：1.每份最少0.1元，2.金额随机分配，3.总金额全部分完
 *      * 写出核心方法：返回List<decimal>且List的长度为x
 *
 * 核心考察点是，要在总金额等于n的情况下尽可能均匀的分配。
 *
 */
public class RedPackage {

    public static void main(String[] args) {
        List<Double> res = new ArrayList<>();
        for(Integer fen : divideRedPackage(10000, 10)) {
            res.add(fen.doubleValue() / 100);
        }
        System.out.println("==================二倍均值法的结果: ");
        System.out.println(res);






        System.out.println();
    }

    /**
     * 二倍均值法
     *  金额单位为分
     *
     *  每次抢到的金额 = 随机区间[0.01, m/n * 2 - 0.01]元
     *  m是剩余金额，n是剩余人数
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, int totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random rand = new Random();
        for(int i = 1; i < totalPeopleNum; i++) {
            // 随机范围: [1, 剩余人均金额的2倍 - 1] 分
            int amount = rand.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        // 最后一人，同时保证了总金额正确
        amountList.add(restAmount);
        return amountList;
    }

    /**
     * 线段分割法
     */
    public static List<BigDecimal> lineSegmentCutting(BigDecimal totalAmount, int totalPeopleNum) {
        List<BigDecimal> amounts = new ArrayList<>();
        if (totalPeopleNum <= 0 || totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            return amounts;
        }
        List<Integer> points = new ArrayList<>();
        // 随机生成num-1个切割点
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            points.add((int) (Math.random() * totalAmount.doubleValue() * 100));
        }
        // 对切割点进行排序
        Collections.sort(points);

        int prev = 0;
        // 根据切割点分配红包金额
        for (int point : points) {
            amounts.add(new BigDecimal(point - prev).divide(new BigDecimal(100)));
            prev = point;
        }
        // 添加最后一个红包金额
        amounts.add(totalAmount.subtract(new BigDecimal(prev).divide(new BigDecimal(100))));
        return amounts;
    }

    /**
     * 洗牌算法，待消化
     */
    public static List<BigDecimal> shuffleAlgorithm(BigDecimal totalAmount, int totalPeopleNum) {
        List<BigDecimal> amounts = new ArrayList<>();
        if (totalPeopleNum <= 0 || totalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            return amounts;
        }
        BigDecimal avg = totalAmount.divide(new BigDecimal(totalPeopleNum), 2, BigDecimal.ROUND_HALF_UP);
        for (int i = 0; i < totalPeopleNum; i++) {
            amounts.add(avg);
        }
        // core
        Collections.shuffle(amounts);
        return amounts;
    }


}
