import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                hashSet.add(numbers[i]+numbers[j]);
            }  
        }
        System.out.println(hashSet);

        int[] answer = hashSet.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        Arrays.sort(answer);
        return answer;
    }
}