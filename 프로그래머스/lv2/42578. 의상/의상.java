import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
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
        return answer;
    }
}