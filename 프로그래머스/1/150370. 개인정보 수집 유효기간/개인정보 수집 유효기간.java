import java.util.*;

class Solution {
    static int year, month, day;
    static ArrayList<Integer> list;
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        list = new ArrayList<>();
        
        for(int i=0; i<terms.length; i++){
            hm.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }
        
        year = Integer.parseInt(today.split("\\.")[0]);
        month = Integer.parseInt(today.split("\\.")[1]);
        day = Integer.parseInt(today.split("\\.")[2]);
        
        for(int i=0; i<privacies.length; i++){
                
            String date = privacies[i].split(" ")[0];
            int term = hm.get(privacies[i].split(" ")[1])*28;
            
            int y = Integer.parseInt(date.split("\\.")[0]);
            int m = Integer.parseInt(date.split("\\.")[1]);
            int d = Integer.parseInt(date.split("\\.")[2]);
            
            int num = (year-y) * 28 * 12 + (month - m) * 28 + (day - d);
            
            if(num >= term){
                list.add(i+1);
            }
            
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        // int[] answer = list.toArray(new int[list.size()]);
        
        
        return answer;
    }
}