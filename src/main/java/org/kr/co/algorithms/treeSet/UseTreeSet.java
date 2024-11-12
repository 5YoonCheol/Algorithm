package org.kr.co.algorithms.treeSet;

import java.util.Collections;
import java.util.TreeSet;

public class UseTreeSet {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-25 오후 10:19
     * @description :
     */
    public int getNthNo(int a, int b, int[] arr){
        int answer = -1;
        //TreeSet 활용 (중복 제거, 정렬)
        //내림차순
        java.util.TreeSet<Integer> Tset = new java.util.TreeSet<>(Collections.reverseOrder());

        for(int i = 0 ; i < a ; i++){
            for(int j = i+1 ; j < a ; j++){
                for(int k = j+1 ; k < a ; k++){
                    Tset.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }

        int index = 0;
        for(int x : Tset){
            index++;
            if(index == b){
                return x;
            }
        }

        return answer;
    }
    
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-12 오후 9:09
     * @description : 현수네 반에는 N명의 학생들이 있습니다.
     * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
     * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
     * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
     */
    public String findDuplication(int a, int[] arr){
        String answer = "D";
        TreeSet<Integer> set = new TreeSet<>();
        for(int x : arr){
            set.add(x);
        }

        if (set.size() == a){
            answer = "U";
        }

        return answer;
    }
    
}
