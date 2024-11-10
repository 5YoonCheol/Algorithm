package org.kr.co.algorithms.lru;

import java.util.LinkedList;

public class LeastRecentlyused {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-10 오후 7:45
     * @description : 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
     * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
     */

    public String cache(int a, int[] arr){
        String answer = "";

        LinkedList<Integer> cache = new LinkedList<>();

        for(int tmp : arr){
            if(cache.contains(tmp)){
                cache.remove(tmp);
            }else{
                if(cache.size() == a){
                    cache.removeLast();
                }
            }
            cache.addFirst(tmp);
        }

        for(int task : cache){
            answer += task + " ";
        }

        return answer.trim();
    }

    /**
     * @author : 5YoonCheol
     * @created : 2024-11-10 오후 7:54
     * @description : cache구현 다른 풀이
     */

    public String otherCache(int a, int[] arr){
        String answer = "";
        int[] cache = new int[a];
        for(int x: arr){
            int pos = -1;
            for(int i=0; i<a; i++){
                if(cache[i] == x){
                    pos = i;
                }
            }
            if(pos == -1){
                for(int i=a-1; i >= 1; i--){
                    cache[i] = cache[i-1];
                }
            }else{
                for(int i=pos; i>=1; i--){
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        for(int x: cache){
            answer += x + " ";
        }
        return answer.trim();
    }
}
