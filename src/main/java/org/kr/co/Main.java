package org.kr.co;

import java.util.*;

public class Main {
    public static ArrayList<Integer> solution(int a, int b, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int lt = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<b-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int rt = b-1; rt < a; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[a];
        for(int i = 0; i < a; i++){
            arr[i] = sc.nextInt();
        }

        for(int x: solution(a,b,arr)){
            System.out.print(x + " ");
        }
    }
}