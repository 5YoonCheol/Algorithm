package org.kr.co.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-01 오후 10:31
     * @description : 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
     * 정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
     * 정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
     * 왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
     * 그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
     * 그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
     * 한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
     * 그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
     * 이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
     * 예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
     * 이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
     * N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
     */
    public int getPrinceNo(int a, int b){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < a; i++){
            queue.offer(i+1);
        }


        while(!queue.isEmpty()){
            //b 번호를 외치는 왕자가 나오기 전까지는 맨 뒤로 보낸다.
            for(int i=1; i < b; i++){
                queue.offer(queue.poll());
            }
            //b 를 외치는 왕자는 제거한다.
            queue.poll();
            //마지막 남은 왕자의 번호가 정답.
            if(queue.size() == 1){
                answer = queue.poll();
            }
        }

        return answer;
    }
    
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-03 오후 7:52
     * @description : 현수는 1년 과정의 수업계획을 짜야 합니다.
     * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
     * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
     * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
     * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
     * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
     * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
     * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
     * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
     */
    public String CheckOrder(String need, String plan){
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char c : need.toCharArray()){
            queue.offer(c);
        }
        for(char c : plan.toCharArray()){
            if(queue.contains(c)){
                if(c != queue.poll()){
                    return "NO";
                }
            }
        }
        if(!queue.isEmpty()){
            return "NO";
        }

        return answer;
    }
    
}
