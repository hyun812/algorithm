import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    public String[] solution(String[] record) {
       HashMap<String, String> id = new HashMap<>();
        for(String s : record){
            if(!s.split(" ")[0].equals("Leave")){
                id.put(s.split(" ")[1], s.split(" ")[2]);
            }
        }

        List<String> arr = new ArrayList<String>();
        for(String s : record){
            if(s.split(" ")[0].equals("Enter")){
                String target = id.get(s.split(" ")[1]) + "님이 들어왔습니다.";
                arr.add(target);
            }   
            else if(s.split(" ")[0].equals("Leave")){
                String target = id.get(s.split(" ")[1]) + "님이 나갔습니다.";
                arr.add(target);
            }
        }
        String[] answer;
        answer = new String[arr.size()];
        arr.toArray(answer);
        
        return answer;
    }
}