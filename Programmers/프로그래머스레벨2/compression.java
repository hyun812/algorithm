
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class compression {
    public static void main(String[] args) {
        String msg = "KAKAO";

        String set = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer> list = new ArrayList<>();
        
        int j=1;
        HashMap<String, Integer> setting = new HashMap<>();

        for(String s : set.split("")){
            setting.put(s, j);
            j++;
        }
        System.out.println(setting);

        //KAKAO
        checktarget(setting, list, msg, j);

        int[] answer = new int[list.size()];
        int idx = 0;
        for(int n : list){
            answer[idx] = n;
            idx++;
        }


        System.out.println(Arrays.toString(answer));
    }

    public static void checktarget(HashMap<String, Integer> setting, ArrayList<Integer> list, String msg, int j){
        for(int i=0; i<msg.length(); i++){
            String target = msg.substring(0, i+1);
            if(!setting.containsKey(target)){
                list.add(setting.get(msg.substring(0,i)));
                setting.put(target, j);
                j++;
                checktarget(setting, list, msg.substring(i), j);
                break;
            }
            else{   
                if (i + 1 == msg.length()) {
                    // 만약 현재 문자가 마지막이라면 마지막 문자 인덱스 출력하기
                    list.add(setting.get(msg.substring(0, i + 1)));
                }
            }
        }
        
        
    }
}
