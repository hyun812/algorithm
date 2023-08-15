import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(bf.readLine());

        HashSet<String> set = new HashSet<String>();

        for(int i=0; i<n; i++){
            String s = bf.readLine();
            set.add(s);
        }
        ArrayList<String> al = new ArrayList<>(set);
        Collections.sort(al, (o1 , o2) ->{
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });

        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
    }
}
