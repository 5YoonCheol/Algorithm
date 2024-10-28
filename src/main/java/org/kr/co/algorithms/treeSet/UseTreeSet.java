package org.kr.co.algorithms.treeSet;

import java.util.Collections;

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
}
