package com.yangfan.leetcode.daily;

/**
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 *
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 *
 * 你可以：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 */
public class Water_and_Jug_Problem {

    public static void main(String[] args) {
        Water_and_Jug_Problem solution = new Water_and_Jug_Problem();
        int jug1Capacity = 3;
        int jug2Capacity = 5;
        int targetCapacity = 4;

        System.out.println("Can measure: " + solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 边界情况：如果目标容量大于两个水壶的总容量，则不可能测量
        if (targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }

        // 如果目标容量为0，总是可以测量（不装水）
        if (targetCapacity == 0) {
            return true;
        }

        // 使用辗转相除法计算最大公约数
        int gcd = gcd(jug1Capacity, jug2Capacity);

        // 贝祖定理：如果targetCapacity是最大公约数的倍数，则可以测量
        return targetCapacity % gcd == 0;
    }

    // 辗转相除法计算最大公约数
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}
