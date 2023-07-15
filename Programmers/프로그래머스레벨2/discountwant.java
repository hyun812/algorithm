
import java.util.*;

public class discountwant {
    // static int day = 0;
    public static void main(String[] args) {
      String[] want = {"banana", "apple", "rice", "pork", "pot"};
      int[] number = {3,2,2,2,1};
      String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
      int answer = 0;
      HashMap<String,Integer> w = new HashMap<>();
      
      for(int j=0; j<want.length; j++){
        w.put(want[j], number[j]);
      }

      for(int i=0; i<discount.length-9; i++){
        System.out.println(discount[i]);
        if(dayCount(i, discount, w)){
          answer++;
        }
      }
      System.out.println(answer);
    }

    static public boolean dayCount(int start, String[] discount, HashMap<String, Integer> w){
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
