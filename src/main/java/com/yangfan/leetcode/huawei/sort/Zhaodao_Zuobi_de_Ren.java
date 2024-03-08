package com.yangfan.leetcode.huawei.sort;

import java.util.*;

public class Zhaodao_Zuobi_de_Ren {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> idScoreMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int score = sc.nextInt();

            idScoreMap.putIfAbsent(id, score);
        }

        List<Map.Entry<Integer, Integer>> dataEntry = new ArrayList<>(idScoreMap.entrySet());
        // 先按照分数，而后id升序
        Collections.sort(dataEntry, (o1, o2)
                -> o1.getValue() == o2.getValue() ?
                o1.getKey().compareTo(o2.getKey()) : o1.getValue().compareTo(o2.getValue()));

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < dataEntry.size() - 1; i++) {
            int sub = dataEntry.get(i + 1).getValue() - dataEntry.get(i).getValue();
            // 出现杀死比赛的选手了
            if(sub == 0) {
                min = sub;
                break;
            } else {
                min = Math.min(sub, min);
            }
        }

        Map<Integer, Integer> pair = new LinkedHashMap<>();
        for(int i = 0; i < dataEntry.size() - 1; i++) {
            int sub = dataEntry.get(i + 1).getValue() - dataEntry.get(i).getValue();
            if(sub == min) {
                pair.put(dataEntry.get(i).getKey(), dataEntry.get(i + 1).getKey());
            }
        }

        List<Map.Entry<Integer, Integer>> sortPair = new ArrayList<>(pair.entrySet());
        Collections.sort(sortPair, Map.Entry.comparingByKey());

        // print
        for(Map.Entry<Integer, Integer> entry: sortPair) {
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }
    }


}
