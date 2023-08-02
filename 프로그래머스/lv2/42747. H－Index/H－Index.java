import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
         int result = 1;
        while(true){
      int temp = 0;
      for(int i=0; i<citations.length; i++){
        if(citations[i] >= result){
          temp++;
        }
      } 
      if(result == temp) break;
      if( result > temp) {
        result--; 
        break;
      }
      else result++;
      
    }
    
        
        return result;
    }
    
}