package com.yangfan.exam.archive;


import java.util.Arrays;
import java.util.Scanner;

/***
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，
 * 每个团队可以由1人或2人组成，且1个人只能参加1个团队，请计算出最多可以派出多少支符合要求的团队？
 *
 * 输入
 * 5
 * 3 1 5 7 9
 * 8
 * 第一行数组代表总人数，范围[1,500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
 * 第三行数值为团队要求的最低能力值，范围[1, 500000]
 *
 * 输出
 * 3
 * 最多可以派出的团队数量
 *
 * 示例:
 * 输入
 * 5
 * 3 1 5 7 9
 * 8
 * 输出
 * 3
 *
 * 说明: 3,5组成一队，1,7组成一队，9自己一个队，故输出3
 */

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int [] peopleData = new int[peopleCount];
        for(int i = 0; i < peopleCount; i++) {
            peopleData[i] = sc.nextInt();
        }
        int level = sc.nextInt();
        Arrays.sort(peopleData);
        int teamNum = 0;
        // 1 3 5 7 9 要8
        // 1人满足情况
        for(int i = peopleData.length - 1; i >= 0; i--) {
            if(peopleData[i] < level)
                break;
            teamNum++;
        }
        // 需要2人组队
        int left = 0;
        int right = peopleData.length - 1 - teamNum;
        while(left < right) {
            if(peopleData[left] + peopleData[right] >= level) {
                teamNum++;
                right--;
            }
            left++;
        }

        System.out.println(teamNum);
    }




}
