
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(bf.readLine());

        HashMap<String, String> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();

            if(hm.containsKey(name) && inout.equals("leave")){
                hm.remove(name);
            }else{
                hm.put(name, inout);
            }
        }
        int i=0;
        String[] result = new String[hm.size()];
        for(String key : hm.keySet()){
            result[i++] = key;
        }

        
        Arrays.sort(result, (o1, o2) ->{
            return o2.compareTo(o1);
        });

        for(int j=0; j<result.length; j++){
            sb.append(result[j]).append("\n");
        }
        
        System.out.println(sb.toString());
    }


}