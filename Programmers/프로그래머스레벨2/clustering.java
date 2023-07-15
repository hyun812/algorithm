
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class clustering {
    public static void main(String[] args) {
        
        String str1 = "A+C";
        String str2 = "DEF";
        


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
        System.out.println(s1);
        
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
        System.out.println(s2);
        System.out.println(set);

        for(String s : set){
            sum += Math.max(s1.getOrDefault(s, 0),s2.getOrDefault(s, 0));
        }

        for(String s : s2.keySet()){
            if(s1.containsKey(s)){
                same += Math.min(s1.get(s), s2.get(s));
            }
        }
        int answer = (int)((double)same/sum*65536);
        //double answer = (double)same/sum*65536;
        // double cal = (double)samecount/s.size();
        // double answer = cal*65536;
        System.out.println(answer);
    }
}
