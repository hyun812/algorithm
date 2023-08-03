import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
       Queue<String> ck = new LinkedList<>();
        if(cacheSize == 0){
            answer = cities.length * 5;                
        }
        else{
            for(String s : cities){ 
                s = s.toLowerCase();
                if(!ck.isEmpty() && ck.contains(s)){
                    ck.remove(s);
                    ck.add(s);
                    answer += 1;
                }
                else{
                    answer += 5;
                    if(ck.size() >= cacheSize){
                        ck.remove();
                        ck.add(s);
                    }
                    else{
                        ck.add(s);
                    }
                }

            }
        }
        return answer;
    }
}