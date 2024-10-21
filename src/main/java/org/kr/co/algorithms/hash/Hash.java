package org.kr.co.algorithms.hash;

import java.util.HashMap;

public class Hash {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-17 오후 10:08
     * @description :학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
     * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
     * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
     * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
     */
    public String getPresident(int n, String chars){
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

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-21 오후 10:27
     * @description : Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
     * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
     * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
     * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
     */
    public String anagram(String a, String b){
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

    /**
     * @author : 5YoonCheol
     * @created : 2024-10-21 오후 10:27
     * @description : anagram 다른 풀이
     */
    public String otherAnagram(String a, String b){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c : a.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : b.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }
        return answer;
    }
}
