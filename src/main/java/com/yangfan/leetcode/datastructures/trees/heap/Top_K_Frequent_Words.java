package com.yangfan.leetcode.datastructures.trees.heap;


import java.util.*;

/**
 * 692. Top K Frequent Words
 *
 * 给定一个单词列表words和一个整数k ，返回前k个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序排序。
 *
 * 如果只要前k个，小根堆足矣
 * 答案要求按照频率的从大到小排序，那就直接用大根堆即可
 *
 * 小顶堆的话堆内存占用小，但是多一次逆序
 */
public class Top_K_Frequent_Words {

    /**
     * 使用大顶堆
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap();
        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 大顶堆
        PriorityQueue<Map.Entry<String, Integer>> heap
                = new PriorityQueue<>((o1, o2) ->
                o2.getValue().compareTo(o1.getValue()) == 0
                        ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            heap.offer(entry);
        }
        List<String> res = new ArrayList<>(k);
        for(int i = 1; i <= k; i++) {
            res.add(heap.poll().getKey());
        }
        return res;
    }


    /**
     * 使用小顶堆
     */
    public List<String> topKFrequentUseLittle(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap();
        for(String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        // 小顶堆 因为用小顶堆拿到的是顺序的，所以这里面字典序要倒序
        PriorityQueue<Map.Entry<String, Integer>> heap
                = new PriorityQueue<>((o1, o2) ->
                o1.getValue().compareTo(o2.getValue()) == 0
                        ? o2.getKey().compareTo(o1.getKey()) : o1.getValue().compareTo(o2.getValue()));
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            // 利用堆的性质省去了比较
            heap.offer(entry);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>(k);
        while(!heap.isEmpty()) {
            res.add(heap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    public List<String> topKFrequentUseMap(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        // 频次相同按字典序
        Collections.sort(rec, (word1, word2) -> cnt.get(word1) == cnt.get(word2)
                ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1));
        return rec.subList(0, k); // 精髓
    }


}
