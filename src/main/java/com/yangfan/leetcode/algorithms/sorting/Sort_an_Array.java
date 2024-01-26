package com.yangfan.leetcode.algorithms.sorting;


/**
 * 912. Sort an Array
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 *
 * 这题的坑点在于，你用O(n^2)的排序算法，会超时。
 * 所以要用O(nlogn)的排序算法。
 * O(nlogn)的排序算法有：
 * 快速排序、归并排序、堆排序、希尔排序、计数排序、桶排序、基数排序。
 * 这里面，计数排序、桶排序、基数排序不适合这道题，因为这三种排序算法都是非比较排序，需要额外的空间。
 *
 * 1. 快速排序 普通快排会超时
 * 2. 归并排序
 * 3. 堆排序
 *
 */
public class Sort_an_Array {

    public static void main(String[] args) {
        Sort_an_Array sort_an_array = new Sort_an_Array();
        int [] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        sort_an_array.sortArray(arr);
    }

    public int[] sortArray(int[] nums) {
        if(nums.length == 1) return nums;
//        mergeSort(nums);
//        quickSort(nums);
        heapSort(nums);
        return nums;
    }

    /**
     * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓归并排序↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
     */
    void mergeSort(int[] nums) {
        process(nums, 0, nums.length - 1);
    }

    void process(int[] nums, int l, int r) {
        int mid = (l + r) >>> 1;
        if(l < r) {
            process(nums, l, mid);
            process(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }
    void merge(int []nums, int left, int mid, int right) {
        // 新开辟一个数组
        int [] temp = new int[right - left + 1];
        // 合并 [left, mid] 与 [mid + 1, right] 区间
        int p1 = left;
        int p2 = mid + 1;
        int k = 0;
        while(p1 <= mid && p2 <= right) {
            temp[k++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        // p1有剩余
        while(p1 <= mid) {
            temp[k++] = nums[p1++];
        }
        // p2有剩余
        while(p2 <= right) {
            temp[k++] = nums[p2++];
        }
        // 把temp数组的值全部灌入原nums
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }
    /**
     * ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑归并排序↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
     */



    /**
     * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓快速排序↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
     */
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        quickProcess(arr, 0, arr.length - 1);
    }

    public static void quickProcess(int[] arr, int L, int R) {
        if(L < R) {
            // int强转相当于向下取整，[0, R-L+1) -> [0, R-L]
            swap(arr, L + (int)(Math.random() * (R -L + 1)), R);  // 交换R和[L, R]范围内的随机位置
            int[] p = partitionPro(arr, L, R);
            quickProcess(arr, L, p[0] - 1); // < 区
            quickProcess(arr, p[1] + 1, R); // > 区
        }
    }

    /**
     * 默认以arr[r]做划分，p = arr[r]。数组按 <p ==p >p 三段划分
     * 返回数组等于区域的[左边界，右边界]
     *
     * 关于less，L，more 三个指针的变化
     * 1. 小于基准值的时候，左边界less+1
     * 2. 小于等于基准值的时候，指针L+1
     * 3. 大于基准值的时候，指针不会动，右边界-1
     */
    public static int[] partitionPro(int[] arr, int L, int R) {
        int less = L - 1; // <区右边界
        int more = R; // >区左边界
        // L表示当前数的位置 arr(R)为基准值
        while(L < more) { // 当遍历指针撞上>区边界，结束遍历
            if(arr[L] < arr[R]) { // 当前数 < 基准值p
                swap(arr, ++less, L++); // 左边界向右推进1，并且交换当前数和左边界值，当前数指针+1
            } else if(arr[L] > arr[R]) { // 当前数 > 基准值p
                // 右边界向左推进1，并且交换当前数与右边界值
                swap(arr, --more, L); // 由于当前值现在是新的未审查过，留到下一轮，L保持不变
            } else {
                // 当前值等于基准值，指针+1
                L++;
            }
        }
        swap(arr, more, R); // 把一开始在最右侧的基准值放在 ==p段的最右侧
        return new int[] {less + 1, more}; // 此刻的more对应的是基准值，也就是交换后的==段的最后一个值
    }
    /**
     * ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑快速排序↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
     */


    /**
     * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓堆排序↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个提取元素，进行排序
        for (int i = n - 1; i > 0; i--) {
            // 将当前最大值移至数组末尾
            swap(arr, 0, i);
            // 重新调整剩余数组，保持最大堆性质
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        // 初始化 largest 为当前节点（父节点）
        int largest = i;
        // 计算左子节点的索引
        int left = 2 * i + 1;
        // 计算右子节点的索引
        int right = 2 * i + 2;
        // 如果左子节点在堆的范围内，且左子节点的值大于当前最大值，则更新最大值的索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // 如果右子节点在堆的范围内，且右子节点的值大于当前最大值，则更新最大值的索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大值的索引不是当前节点，说明子节点中有更大的值
        if (largest != i) {
            // 交换当前节点和最大值的节点，将最大值移到父节点的位置
            swap(arr, i, largest);
            // 递归调整被交换的子树，以确保子树仍然满足最大堆的性质
            heapify(arr, n, largest);
        }
    }
    /**
     * ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑堆排序↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
     */

    public static void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }


}
