package com.yangfan.exam.archive;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
 * 地图表示为一维数组，数组的索引代表水平位置，数组的高度代表相对海拔高度。其中数组元素0代表地面。
 *
 * 例如[0,1,4,3,1,0,0,1,2,3,1,2,1,0], 代表如下图所示的地图，
 * 地图中有两个山脉位置分别为 1,2,3,4,5和8,9,10,11,12,13，最高峰高度分别为4,3。最高峰位置分别为3,10。
 * 一个山脉可能有多座山峰(高度大于两边，或者在地图边界)。
 */
public class Main3 {

    public static void main(String[] args) {
        int [] nums = {0,1,4,3,1,0,0,1,2,3,1,2,1,0};
        System.out.println(nums.length);
    }

    /**
     * 获取可以攀登的山峰数量
     * @param hill_map int整型一维数组 地图
     * @param strength int整型 登山者的体力值
     * @return int整型
     *
     * 判断山峰
     * 左右的0都可以为起点
     *
     */
    public int count_climbable (int[] hill_map, int strength) {
        int hillCount = 0; // 山峰数
        Set<Integer> hills = new HashSet<>();
        int mapLen = hill_map.length; // 地图长度

        int i = 0;
        // 找到峰
        while(true) {
            if(i < mapLen) {
                if(hill_map[i] != 0) {
                    // 左侧峰
                    if(i == 0 && hill_map[i] > hill_map[i + 1]
                            // 右侧峰
                            || i == mapLen - 1 && hill_map[i] > hill_map[i - 1]
                            // 中间峰
                            || hill_map[i - 1] < hill_map[i] && hill_map[i] > hill_map[i + 1]) {
                        hills.add(i);
                    }
                }
                i++;
            } else {
                break;
            }
        }

        int [][] left = new int[mapLen][2];
        int [][] right = new int[mapLen][2];

        for(int j = 0; j < mapLen; j++) {
            if(hill_map[j] == 0) {
                left[j][0] = 0;
                left[j][1] = 0;
            } else {
                // 下坡
                if(hill_map[j] > hill_map[j - 1]) {
                    left[j][0] = left[j - 1][0] + (hill_map[j] - hill_map[j - 1]);
                }
                // 上坡
                else {
                    left[j][1] = left[j - 1][1] + hill_map[j - 1] - hill_map[j];
                }

            }

        }

//        return (int)(Math.random(0, 3)) + 1;
        return hillCount;
    }


}
