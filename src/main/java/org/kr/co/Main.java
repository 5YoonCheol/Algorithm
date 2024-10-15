package org.kr.co;

import java.util.*;

public class Main {
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        int sum = 0;

        int start = 0;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == m){
                answer++;
                sum = 0;
                start++;
                i = start-1;
            }
            else if(sum > m){
                sum = 0;
                start++;
                i = start-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }



        System.out.print(solution(n, m, arr));
    }
}