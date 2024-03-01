package com.yangfan.leetcode.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ68 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 人数
        int order = sc.nextInt(); // 排序 1 正 0 反
        List<Student> data = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            Student s = new Student(name, score);
            data.add(s);
        }
        if(order == 1) {
            Collections.sort(data);
        } else {
            Collections.sort(data, Collections.reverseOrder());
        }

        // print
        for(int i = 0; i < n; i++) {
            Student s = data.get(i);
            System.out.println(s.name + " " + s.score);
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int score;

        public Student() {}
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if(this.score - o.score > 0) {
                return 1;
            } else if(this.score - o.score < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
