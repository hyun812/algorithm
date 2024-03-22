import java.util.*;
// cap -> 트럭에 실을 수 있는 최대 댁배 상자
// 각 집에 배달 + 수거해 물류창고로
// 배달 및 수거를 마치고 돌아올 수 있는 최소 이동거리 ( 원하는 개수만큼 배달 및 수거 가능 )

// 끝에서부터 빨리 가져와야 함
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Integer> delStack = new Stack<>();
        Stack<Integer> pickStack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < deliveries[i]; j++) {
                delStack.push(i + 1);
            }
            
            for (int j = 0; j < pickups[i]; j++) {
                pickStack.push(i + 1);
            }
        }

        // 배달 및 수거할 택배가 있으면 반복
        while(!delStack.isEmpty() && !pickStack.isEmpty()){
            
            int lastDel = delStack.peek();
            int lastPick = pickStack.peek();
            
            for(int i=0; i<cap; i++){
                if(!delStack.isEmpty()) delStack.pop();
                if(!pickStack.isEmpty()) pickStack.pop();
            }
            
            answer += Math.max(lastDel, lastPick) * 2;
        }
        
        // 남아있는 배달 또는 수거할 택배 확인
        while(!delStack.isEmpty()){
            int lastDel = delStack.peek();
            
            for(int i=0; i<cap; i++){
                if(!delStack.isEmpty()) delStack.pop();
            }
            
            answer += lastDel * 2;
        }
        
        while(!pickStack.isEmpty()){
            int lastPick = pickStack.peek();
            
            for(int i=0; i<cap; i++){
                if(!pickStack.isEmpty()) pickStack.pop();
            }
            
            answer += lastPick * 2;
        }
        
        
        return answer;
    }
}