package org.kr.co.algorithms.stack;

import java.util.Stack;

public class UseStack {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-28 오후 8:53
     * @description : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
     * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
     */

    public String properBrackets(String str){
        Stack<Character> stack = new java.util.Stack<>();
        
        for (Character c : str.toCharArray()) {
            if(c.equals('(')){
                stack.push(c);
            }else if(c.equals(')')){
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}
