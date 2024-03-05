package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NC37 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // 如果区间列表为空或只有一个区间，直接返回原列表
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // 对区间列表按照区间起始位置进行升序排序
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        // 创建一个新的列表用于存储合并后的区间
        ArrayList<Interval> merged = new ArrayList<>();
        // 将排序后的第一个区间作为当前区间
        Interval current = intervals.get(0);
        // 将当前区间添加到合并后的区间列表中
        merged.add(current);
        // 遍历排序后的区间列表
        for (Interval next : intervals) {
            // 如果当前区间的结束位置大于等于下一个区间的起始位置，说明有重叠
            if (current.end >= next.start) {
                // 更新当前区间的结束位置为两个区间结束位置的较大值，以合并区间
                current.end = Math.max(current.end, next.end);
            } else {
                // 如果没有重叠，将下一个区间作为新的当前区间，并添加到合并后的区间列表中
                merged.add(next);
                current = next;
            }
        }
        // 返回合并后的区间列表
        return merged;
    }

}

class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
}

