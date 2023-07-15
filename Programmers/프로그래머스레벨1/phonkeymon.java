package 프로그래머스레벨1;

import java.util.HashSet;

//레벨1 - 폰켓몬
public class phonkeymon {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;

        int length = nums.length/2;

        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            hashSet.add(nums[i]);  
        }
        
        if(hashSet.size() >= length){
            answer = length;
        }
        else{
            answer = hashSet.size();
        }
        System.out.println(answer);
    }
}
