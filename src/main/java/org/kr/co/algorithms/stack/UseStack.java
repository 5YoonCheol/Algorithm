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

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-29 오후 9:58
     * @description : 크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
     * 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
     * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
     * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
     * 0은 빈 칸을 나타냅니다.
     */
    public int peekDolls(int a, int b, int[][] arr, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for (int i = 0; i < a; i++){
                if(arr[i][pos-1] != 0){
                    int tmp = arr[i][pos-1];
                    arr[i][pos-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == tmp){
                        stack.pop();
                        answer += 2;
                    }
                    else{
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-31 오후 9:30
     * @description : 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
     * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
     */
    public int getResult(String a){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char c : a.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }else{
                int rt = Integer.parseInt(stack.pop().toString());
                int lt = Integer.parseInt(stack.pop().toString());

                if(c == '+'){
                    stack.push(lt + rt);
                }else if(c == '-'){
                    stack.push(lt - rt);
                }else if(c == '*'){
                    stack.push(lt * rt);
                }else if(c == '/'){
                    stack.push(lt / rt);
                }
            }
        }
        answer = stack.pop();

        return answer;
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-01 오후 9:30
     * @description :  여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
     * 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
     * • 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되,
     * 끝점은 겹치지 않도록 놓는다.
     * • 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
     * • 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
     * 아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치,
     * 수직으로 그려진 점선 화살표는 레이저의 발사 방향이다.
     * 이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
     * 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 드시 레이저를 표현한다.
     * 2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
     * 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
     */
    public int getCuttedPipe(String a){
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<a.length(); i++){
            if(a.charAt(i) == '('){
                stack.push(a.charAt(i));
            }else if(a.charAt(i) == ')'){ // 닫는 괄호 바로 앞이 여는 괄호일 경우 레이저
                stack.pop();
                if(a.charAt(i-1) == ')'){ // 닫는 괄호 바로 앞이 닫는 괄호일 경우 쇠 막대기의 끝
                    answer += 1;
                }else{
                    answer += stack.size();
                }
            }
        }

        return answer;
    }

}
