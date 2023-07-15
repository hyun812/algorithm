
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class openchat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        //채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
        //채팅방에서 닉네임을 변경한다. 

    
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

        System.out.println(Arrays.toString(answer));
    }
}
