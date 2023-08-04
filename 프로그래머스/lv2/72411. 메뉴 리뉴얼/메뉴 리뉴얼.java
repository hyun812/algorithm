import java.util.*;
import java.util.Map.Entry;
class Solution {
    
    // 12. combi 메소드에서 map에 접근하기 위해 전역변수로 선언.
    static HashMap<String,Integer> od; 
    // 13. 조합을 구하는 메소드 (한 사람의 메뉴구성, 조합을 구할 StringBuilder, 조합을 위한 idx, 코스요리 개수에 따른 종료조건을 위한 cnt와 n)
    public static void comb(String str,StringBuilder sb,int idx, int cnt, int n){
        // 14. 각 코스요리의 개수만큼 조합이 되면,
       if(cnt == n) {
           // 15. map에 해당 조합을 삽입 및 카운팅.
           od.put(sb.toString(),od.getOrDefault(sb.toString(),0)+1);
           return;
        }
        
        // 16. idx부터 시작함으로써 조합을 구할 수 있다.
        for(int i = idx ; i<str.length();i++){
            // 17. sb에 붙여나간다.
            sb.append(str.charAt(i));
            // 18. 재귀호출.
            comb(str,sb,i+1,cnt+1,n);
            // 19. 붙였던거 다시 떼기.
            sb.delete(cnt,cnt+1);
        }
    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
       ArrayList<String> answer = new ArrayList<>();
    
    for(int i=0; i<orders.length; i++){
      char[] chars = orders[i].toCharArray();
      Arrays.sort(chars);
      orders[i] = new String(chars);
    }

    for(int i=0; i<course.length; i++){
      od = new HashMap<>();
 int max = Integer.MIN_VALUE;   
      for(int j =0;j<orders.length;j++){
        StringBuilder sb = new StringBuilder(); 
        if(course[i]<=orders[j].length()){
          comb(orders[j],sb,0,0,course[i]);  
        }                             
      }

      for(Entry<String,Integer> entry : od.entrySet()){
                    max = Math.max(max,entry.getValue());
                   
            }
            // 21. 최소 2번 이상 주문된 조합이며, 해당 횟수와 일치하는 조합은 ArrayList에 삽입.
            for(Entry<String,Integer> entry : od.entrySet()){
                    if(max >=2 && entry.getValue() == max)
                        answer.add(entry.getKey());
            }
    }
   
    Collections.sort(answer);
        
        return answer;
    }
}