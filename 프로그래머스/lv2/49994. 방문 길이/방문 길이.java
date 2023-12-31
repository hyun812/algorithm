import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<String>();
    String from = "0 0";

    for(int i=0; i<dirs.length(); i++){
      String target = dirs.split("")[i];
      int x = Integer.parseInt(from.split(" ")[0]);  
      int y = Integer.parseInt(from.split(" ")[1]);

      if(target.equals("U")){
        y += 1;
      }
      else if(target.equals("L")){
        x -= 1;
      }
      else if(target.equals("D")){
        y -= 1;
      }
      else if(target.equals("R")){
        x += 1;
      }
        if(x > 5 || y > 5 || x < -5 || y < -5) continue;
      String to = Integer.toString(x) + " " +Integer.toString(y);
      set.add(from+" "+to);
      set.add(to+" "+from);
      from = to;
    }
        answer = set.size()/2;
        return answer;
    }
}