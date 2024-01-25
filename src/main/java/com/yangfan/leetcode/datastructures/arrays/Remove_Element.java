package com.yangfan.leetcode.datastructures.arrays;
/************************************************
 *
 * 27. 移除元素
 *
 * 不使用额外空间，移除数组中与指定数值相等的元素
 * 然后返回新数组的长度
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，
 * 而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,3,0,4]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 这道题学到的:
 * 1. 快慢指针
 * 2. 前后双指针
 *
**************************************************/
public class Remove_Element {

	/**
	 * 这个解法本质上是快慢指针
	 * 快指针遍历全数组进行比较，慢指针放入不等于val的元素
	 *
	 * 用于赋值的i，其实就是慢指针
	 * 而慢指针永远不会超过快指针，所以不用担心覆盖
	 */
	public int fastSlow(int[] nums, int val) {
		int p = 0;
		for(int n : nums)
			if(n != val)
				nums[p++] = n;
		return p;
	}

	/**
	 * 头尾双指针
	 * 仅当头指针指向的元素等于val时，才把尾部元素赋值给头指针
	 *
	 * 优化了快慢指针的冗余复制问题
	 */
	public int headTail(int[] nums, int val) {
		int tail = nums.length - 1;
		int head = 0;
		while(head <= tail) {
			if(nums[head] == val) {
				nums[head] = nums[tail--];
			} else {
				head++;
			}
		}
		return head;
	}



}
