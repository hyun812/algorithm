import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int max;
    static int[] taste;
    static int[] calorie;
    static boolean[] isSelected;
    static int n;
    static int l;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(bf.readLine());
        
        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            taste = new int[n];
            calorie = new int[n];
            isSelected = new boolean[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }

            check(0);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
           
        }
         System.out.println(sb.toString());
    }


    public static void check(int cnt) {
        if(cnt == n){
            int sumT = 0;
            int sumC = 0;
            for(int i=0; i<n; i++){
                if(isSelected[i]){
                    sumT += taste[i];
                    sumC += calorie[i];
                }
            }

            if(sumC <= l){
                max = Math.max(max, sumT);
            }
            
            return;
        }

        isSelected[cnt] = true;
        check(cnt+1);
        isSelected[cnt] = false;
        check(cnt+1);
    }
}
