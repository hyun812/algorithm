import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        ArrayList<int[]> al = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            al.add(new int[] {a,b});

        }

        Collections.sort(al, (o1 , o2) ->{
            if(o1[1] == o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i)[0] + " " + al.get(i)[1]);
        }
    }
}
