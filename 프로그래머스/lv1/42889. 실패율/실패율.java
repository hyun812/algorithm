import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);

        HashMap<Integer,Integer> loss = new HashMap<>();

        for(int i=1; i<=N+1; i++){
            loss.put(i, 0);
        }
        for(int i : stages){
            loss.put(i, loss.get(i)+1);
        }
        
        double[] result = new double[N];

        int count = stages.length;
        for(int i=0; i<result.length; i++){
            if(count == 0){
                result[i] = 0;
            }
            else{
                int j = loss.get(i+1);
                result[i] = (double)j/count;
                count = count-loss.get(i+1);
            }
        }
        
        HashMap<Integer,Double> indexK = new HashMap<>();
        for(int i=0; i<result.length; i++){
            indexK.put(i+1, result[i]);
        }

        List<Integer> listKeySet = new ArrayList<>(indexK.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (indexK.get(value2).compareTo(indexK.get(value1))));
        
        int[] answer = listKeySet.stream()
                    .mapToInt(Integer::intValue)
                    .toArray(); 
        
        return answer;
    }
}