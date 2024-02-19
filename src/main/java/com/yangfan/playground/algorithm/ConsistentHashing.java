package com.yangfan.playground.algorithm;

import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 一致性hash实现
 */
public class ConsistentHashing {
    // 使用TreeMap作为哈希环
    private final SortedMap<Integer, String> circle = new TreeMap<>();

    // 添加节点
    public void addNode(String node, int numberOfReplicas) {
        for (int i = 0; i < numberOfReplicas; i++) {
            // 对节点名和副本编号进行哈希来模拟环上的多个点
            int hash = getHash(node + i);
            circle.put(hash, node);
        }
    }

    // 移除节点
    public void removeNode(String node, int numberOfReplicas) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(node + i);
            circle.remove(hash);
        }
    }

    // 获取数据项所属的节点
    public String getNode(String itemKey) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = getHash(itemKey);
        if (!circle.containsKey(hash)) {
            // 返回此映射的部分视图，其键大于等于hash
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    // 简单的哈希函数实现，实际应用中可能需要更复杂的哈希算法
    private int getHash(String key) {
        return key.hashCode() & 0xfffffff;
    }

    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing();
        ch.addNode("Node1", 3);
        ch.addNode("Node2", 3);
        ch.addNode("Node3", 3);

        System.out.println("Item1 is located at: " + ch.getNode("Item1"));
        System.out.println("Item2 is located at: " + ch.getNode("Item2"));
        System.out.println("Item3 is located at: " + ch.getNode("Item3"));

        ch.removeNode("Node2", 3);

        System.out.println("After removing Node2:");
        System.out.println("Item1 is located at: " + ch.getNode("Item1"));
        System.out.println("Item2 is located at: " + ch.getNode("Item2"));
        System.out.println("Item3 is located at: " + ch.getNode("Item3"));
    }
}
