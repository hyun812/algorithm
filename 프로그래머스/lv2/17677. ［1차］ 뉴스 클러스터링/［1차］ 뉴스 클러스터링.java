import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int same = 0;
        int sum = 0;
        HashMap<String, Integer> s1 = new HashMap<>();
        HashMap<String, Integer> s2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<str1.length()-1; i++){
            String target = str1.substring(i, i+2).toLowerCase();
            if(Pattern.matches("^[a-zA-Z]*$", target)){
                s1.put(target, s1.getOrDefault(target, 0) +1);
                set.add(target);
            }
            else continue;
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String target = str2.substring(i, i+2).toLowerCase();
            if(Pattern.matches("^[a-zA-Z]*$", target)){
                //samecount++;
                s2.put(target, s2.getOrDefault(target, 0) +1);
                set.add(target);
            }
            else{
                //s2.put(target, s2.getOrDefault(target, 0) +1);
                continue;
            }
            
        }

        for(String s : set){
            sum += Math.max(s1.getOrDefault(s, 0),s2.getOrDefault(s, 0));
        }

        for(String s : s2.keySet()){
            if(s1.containsKey(s)){
                same += Math.min(s1.get(s), s2.get(s));
            }
        }
        if(sum == 0) return 65536;
        else return same*65536/sum;
    }
}