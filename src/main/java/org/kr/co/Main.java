package org.kr.co;

import java.util.*;

public class Main {
    public static String solution(String a, String b){
        String answer = null;
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for(Character c : a.toCharArray()){
            aMap.put(c, aMap.getOrDefault(c, 0) + 1);
        }

        for(Character c : b.toCharArray()){
            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
        }

        if(aMap.equals(bMap)){
            answer = "YES";
        }else{
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();


        System.out.print(solution(a,b));
    }
}