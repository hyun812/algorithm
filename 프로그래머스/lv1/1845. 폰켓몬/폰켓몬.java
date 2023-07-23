import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
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
        
        return answer;
    }
}