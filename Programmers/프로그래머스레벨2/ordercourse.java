import java.util.*;

public class ordercourse {
  static HashMap<String, Integer> od;
  public static void main(String[] args) {
    String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
    int[] course = {2,3,5};
    ArrayList<String> answer = new ArrayList<>();
    
    for(int i=0; i<orders.length; i++){
      char[] chars = orders[i].toCharArray();
      Arrays.sort(chars);
      orders[i] = new String(chars);
    }

    for(int i=0; i<course.length; i++){
      od = new HashMap<>();

      for(int j =0;j<orders.length;j++){
        StringBuilder sb = new StringBuilder(); 
        if(course[i]<=orders[j].length()){
          comb(orders[j],sb,0,0,course[i]);  
        }                             
      }

      Integer maxValue = Collections.max(od.values());
      for(String s : od.keySet()){
        if(od.get(s) == maxValue && od.get(s) >= 2){
          answer.add((s));
        }
      }
    }
   
    Collections.sort(answer);
    System.out.println(answer);
  }
  static void comb(String str,StringBuilder sb,int idx, int cnt, int n){
    if(cnt == n) {
      od.put(sb.toString(),od.getOrDefault(sb.toString(),0)+1);
      return;
    }
    for(int i = idx ; i<str.length();i++){
      sb.append(str.charAt(i));
      comb(str,sb,i+1,cnt+1,n);
      sb.deleteCharAt(cnt);
    }
  }
}