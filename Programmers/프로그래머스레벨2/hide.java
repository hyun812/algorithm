import java.util.Arrays;
import java.util.HashMap;

public class hide {
    public static void main(String[] args) {
        String[][] clothes = {{"a", "headgear"}, {"b", "headgear"}, {"c", "eyewear"}, {"d", "eyewear"}, {"e", "face"}, {"f", "face"}};

        HashMap<String, Integer> hm = new HashMap<>();
        int answer = 0;
        for(int i=0; i<clothes.length; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) +1);
        } 
        if(hm.size() > 1) {
            int count = 1;

            for(String key : hm.keySet()){
                count *= hm.get(key) + 1;
            }

            answer = count - 1;
        }else{
            answer = clothes.length;
        }
        System.out.println(answer);
    }
}
