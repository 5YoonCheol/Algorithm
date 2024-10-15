package org.kr.co.algorithms;

public class AlgorithmCode {
    /**
     * @author : 5YoonCheol
     * @created : 2024-10-15 오후 9:24
     * @updated : 2024-10-15 오후 9:24
     * @description : 연속 부분수열
     */
    public int numberOfCase(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){
            sum += arr[rt];
            if(sum == m){ answer ++; }
            while(sum >= m){
                sum -= arr[lt++];
                if(sum == m){ answer ++; }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        AlgorithmCode algorithmCode = new AlgorithmCode();

        //실행할 함수 호출
        algorithmCode.numberOfCase(4, 3, new int[]{1,2,3});
    }
}
