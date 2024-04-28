package com.yangfan.leetcode.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 力扣给的例子有误导人的意思，"()[]{}"算，“([{}])”也算
 * 这道题不难，主要是边界情况的考虑
 */
public class Valid_Parentheses {
	
	public static void main(String[] args) {
		 Valid_Parentheses valid = new Valid_Parentheses();
		 System.out.println("------------");
		 System.out.println(valid.isValid1("()"));
		 System.out.println("------------");
		 
	}
	
	//方法一
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
  	    for(char c : s.toCharArray()) {
  	    	if(c == '(') {
  	    		stack.push(')');
  	    	} else if(c == '['){
  	    		stack.push(']');
  	    	} else if(c == '{'){
  	    		stack.push('}');
  	    	} else if(stack.isEmpty() || stack.pop() != c){
  	    		return false;
  	    	}
  	    }
		return stack.isEmpty();
     }
	
	/**
	 * 比较暴力的方法，括号如果嵌套的话效率会比较低
	 * 看看即可
	 */
	public boolean isValid1(String s){
		if(s.length() % 2 != 0) return false;
		int len = 0;
		while(len != s.length()) {
			len = s.length();
			s = s.replace("()", "").replace("[]","").replace("{}","");
		}
		return s.length() == 0;
	}
	
	
       
}
