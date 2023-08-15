import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        HashSet<Integer> hs = new HashSet<>();

        HashMap<Integer,Integer> hm = new HashMap<>();
        Integer[] arr = new Integer[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            hs.add(a);
            arr[i] = a;
        }
        
        Integer[] clone = arr.clone();
        Arrays.sort(clone, (o1, o2)->{
            return o2-o1;
        });
        
        int cnt = hs.size()-1;
        hm.put(clone[0], cnt);

        for(int i=1; i<clone.length; i++){
            if(clone[i].equals(clone[i-1])){
                continue;
            }
            hm.put(clone[i], --cnt);
        }

        for(int i=0; i<arr.length; i++){
            sb.append(hm.get(arr[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
