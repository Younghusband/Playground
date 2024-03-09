package com.yangfan.leetcode.huawei.search;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class XiaoMing_Zhaoweizhi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while(sc.hasNext()) {
            String originData = sc.nextLine().trim();
            String [] idStr = originData.split(",");
            int [] nums = new int[idStr.length];
            for(int i = 0; i < idStr.length; i++) {
                nums[i] = Integer.parseInt(idStr[i]);
            }

            Integer target = Integer.valueOf(sc.nextLine().trim());
            int location = find(nums, target) + 1;
            System.out.println(location);
        }
    }

    static int find(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}
