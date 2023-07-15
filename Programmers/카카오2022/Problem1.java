package 카카오2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Problem1 {
    public static void main(String[] args) {
        String[] id_list = new String[] {"muzi", "frodo", "apeach", "neo"};
        int[] answer = new int[id_list.length];
        int k=2;
        String[] report = new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> reported = new HashMap<>();
        
        for(String user_id : id_list){
            reported.put(user_id, 0);
        }
        
        for(String i : report_set){
            reported.put(i.split(" ")[1], reported.get(i.split(" ")[1]) +1);
        }
        
        for(String i : report_set){
           if(reported.get(i.split(" ")[1]) >= k){
               answer[Arrays.asList(id_list).indexOf(i.split(" ")[0])] += 1;
           } 
        }
        
        System.out.println(report_set);
        System.out.println(reported);

        System.out.println(Arrays.toString(answer));
    }
}

