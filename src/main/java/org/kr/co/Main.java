package org.kr.co;

import java.util.*;

public class Main {
    public static String solution(int n, String chars){
        String answer = null;
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c : chars.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for(Character c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
                answer = String.valueOf(c);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String chars = sc.next();


        System.out.print(solution(n, chars));
    }
}