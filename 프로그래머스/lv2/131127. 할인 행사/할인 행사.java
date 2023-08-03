import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
int answer = 0;
      HashMap<String,Integer> w = new HashMap<>();
      
      for(int j=0; j<want.length; j++){
        w.put(want[j], number[j]);
      }

      for(int i=0; i<discount.length-9; i++){
        if(dayCount(i, discount, w)){
          answer++;
        }
      }
      
        return answer;
    }
    
    public boolean dayCount(int start, String[] discount, HashMap<String, Integer> w){
      int left = start;
      int right = start+9;
      HashMap<String,Integer> ch = new HashMap<>();
      for(int i=left; i<=right; i++){
        ch.put(discount[i], ch.getOrDefault(discount[i], 0)+1);
      }

      for(String s : w.keySet()){
        if(!ch.containsKey(s) || w.get(s) != ch.get(s)){
          return false;
        }
      }

      return true;
    }
}