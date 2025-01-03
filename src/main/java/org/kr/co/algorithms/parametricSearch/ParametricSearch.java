package org.kr.co.algorithms.parametricSearch;

import java.util.Arrays;

public class ParametricSearch {
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-14 오후 9:26
     * @description : 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
     * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
     * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
     * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
     * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
     * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
     * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
     */
    public int count(int[] arr, int capacity){
        int cnt = 1;
        int sum = 0;

        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            }else{
                sum += x;
            }
        }

        return cnt;
    }

    public int parametricSearch(int[] arr, int total, int target) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= target){
                answer = target;
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

        return answer;
    }
    
    /**
     * @author : 5YoonCheol
     * @created : 2024-11-15 오후 6:45
     * @description : N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
     * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
     * 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
     * C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
     */
    public int horseCount(int[] arr, int distance){
        int cnt = 1;
        int sum = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] - sum >= distance){
                cnt++;
                sum = arr[i];
            }
        }

        return cnt;
    }

    public int getMaxLength(int a, int b, int[] arr){
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[a-1];

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(horseCount(arr, mid) >=  b){
                answer = mid;
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }
        }

        return answer;
    }
    
    
}
