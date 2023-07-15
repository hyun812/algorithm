import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * selectmandarin
 */

public class selectmandarin {
  public static void main(String[] args) {
    int k = 2;
    int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
    int count = 0;

    Map<Integer,Integer> tanMap = new HashMap<>();
    
    for(int i=0; i<tangerine.length; i++){
      tanMap.put(tangerine[i], tanMap.getOrDefault(tangerine[i], 0)+1);
    }
    
    List<Integer> keyList = new ArrayList<>(tanMap.keySet());
    keyList.sort(((o1, o2) -> tanMap.get(o2) - tanMap.get(o1)));

    for(Integer key: keyList){
      k -= tanMap.get(key);
      count++;
      if(k <= 0) break;
    }
    
    System.out.println(tanMap);
    System.out.println(keyList);
    System.out.println(count);
  }
}