
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        s = s.substring(1, s.length()-2);
        s = s.replaceAll("\\{", "");
        String[] arr = s.split("},");
        System.out.println(Arrays.toString(arr));
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(String n : arr){
            String[] arr_n = n.split(",");
            for(int i=0; i<arr_n.length; i++){
                int target = Integer.parseInt(arr_n[i]);
                hm.put(target, hm.getOrDefault(target, 0)+ 1);
            }
        }

        System.out.println(hm);
        List<Integer> listKeySet = new ArrayList<>(hm.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (hm.get(value2).compareTo(hm.get(value1))));
        int[] answer = new int[listKeySet.size()];
        int i=0;
        for(Integer key : listKeySet) {
			answer[i] = key;
            i++;
		}

        System.out.println(Arrays.toString(answer));
    }    
}
