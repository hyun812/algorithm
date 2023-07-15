package 프로그래머스레벨1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

// 레벨1 - 두 개 뽑아서 더하기
public class SumTwoNum {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        
        HashSet<Integer> hashSet = new HashSet<>();
        

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                hashSet.add(numbers[i]+numbers[j]);
            }  
        }
        System.out.println(hashSet);

        int[] primitive = hashSet.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        Arrays.sort(primitive);
    }
}
