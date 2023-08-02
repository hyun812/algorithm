import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
         Map<Integer,Integer> tanMap = new HashMap<>();
    
    for(int i=0; i<tangerine.length; i++){
      tanMap.put(tangerine[i], tanMap.getOrDefault(tangerine[i], 0)+1);
    }
    
    List<Integer> keyList = new ArrayList<>(tanMap.keySet());
    keyList.sort(((o1, o2) -> tanMap.get(o2) - tanMap.get(o1)));


    for(int i=0; i<keyList.size(); i++){

      k = k-tanMap.get(keyList.get(i));
      answer++;
      if(k <= 0) break;

    }
        return answer;
    }
}