
import java.util.LinkedList;
import java.util.Queue;

/**
 * cache
 */
public class cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"A","B","A"};
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
        
        System.out.println(answer);
    }
}

