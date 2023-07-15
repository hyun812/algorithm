package 프로그래머스레벨1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//레벨1 - 실패율
public class lossRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,2,2,2,2};

        Arrays.sort(stages);

        System.out.println(Arrays.toString(stages));
        HashMap<Integer,Integer> loss = new HashMap<>();

        for(int i=1; i<=N+1; i++){
            loss.put(i, 0);
        }
        for(int i : stages){
            loss.put(i, loss.get(i)+1);
        }
        System.out.println(loss);
        
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
        
        System.out.println(Arrays.toString(result));
        
        HashMap<Integer,Double> indexK = new HashMap<>();
        for(int i=0; i<result.length; i++){
            indexK.put(i+1, result[i]);
        }

        System.out.println(indexK);
        List<Integer> listKeySet = new ArrayList<>(indexK.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (indexK.get(value2).compareTo(indexK.get(value1))));
        
        System.out.println(listKeySet);
        int[] answer = listKeySet.stream()
                    .mapToInt(Integer::intValue)
                    .toArray(); 

        System.out.println(Arrays.toString(answer));
        // int[] answer = new int[n];
        // for(int j=0; j<n; j++){
        //     answer[j] = resultarr[n-j-1];
        // }
    }
}
