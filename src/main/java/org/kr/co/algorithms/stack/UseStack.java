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
        Stack<Character> stack = new Stack<>();
        
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
    
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-28 오후 9:30
     * @description : 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
     */
    public String deleteBrackets(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (Character c : str.toCharArray()) {
            if(c.equals('(')){
                stack.push(c);
            }else if(c.equals(')')){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{ // (, ) 가 아닌 경우 stack이 비어 있다면 괄호로 감싸지지 않은 값
                if(stack.isEmpty()){
                    answer += c;
                }
            }
        }
        return answer;
    }


    /**
     * @author : 5YoonCheol
     * @created : 2024-10-28 오후 9:35
     * @description : 위 문제의 다른 풀이
     */
    public String deleteBrackets2(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (Character c : str.toCharArray()) {
            if(c.equals(')')){
                while(stack.pop() != '('); //닫는 괄호를 만나면 '(' 가 나올까지 stack에서 꺼내준다.
            }
            else {
                stack.push(c);
            }
        }

        for(Character c : stack){
            answer += c;
        }
        return answer;
    }
    
}
