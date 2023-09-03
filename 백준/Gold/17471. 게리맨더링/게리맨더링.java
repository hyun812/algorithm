import java.util.*;
import java.io.*;

public class Main {

    static int[] pnums;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int n;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        pnums = new int[n];
        visited = new boolean[n];
        ans = Integer.MAX_VALUE;

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            pnums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int end = Integer.parseInt(st.nextToken());
            for(int j=0; j<end; j++){
                int to = Integer.parseInt(st.nextToken());

                list[i].add(to-1);
            }
        }

        powerSet(0);

        if(ans == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(ans);
        }
    }

    private static void powerSet(int cnt){
        if(cnt == n){
            ArrayList<Integer> al1 = new ArrayList<>();
            ArrayList<Integer> al2 = new ArrayList<>();

            for(int i=0; i< n; i++){
                if(visited[i]){
                    al1.add(i);
                }
            }

            for(int i=0; i< n; i++){
                if(!visited[i]){
                    al2.add(i);
                }
            }

            if(al1.isEmpty() || al2.isEmpty()){
                return;
            }

            if(check(al1) && check(al2)){
                diff(al1, al2);
            }
            return;
        }

        visited[cnt] = true;
        powerSet(cnt+1);
        visited[cnt] = false;
        powerSet(cnt+1);
    }

    private static boolean check(ArrayList<Integer> li){

        Queue<Integer> q = new LinkedList<>();
        boolean[] ckarr = new boolean[n];
        ckarr[li.get(0)] = true;
        q.add(li.get(0));

        int count = 1;

        while (!q.isEmpty()){
            int poll = q.poll();
            for(int i=0; i<list[poll].size(); i++){
                int ck = list[poll].get(i);
                if(li.contains(ck) && !ckarr[ck]){
                    ckarr[ck] = true;
                    q.add(ck);
                    count++;
                }
            }
        }

        if(li.size() == count){
            return true;
        }
        return false;
    }

    private static void diff(ArrayList<Integer> al1, ArrayList<Integer> al2){
        int cnt1 = 0;
        int cnt2 = 0;
        for(Integer i : al1){
            cnt1 += pnums[i];
        }
        for(Integer i : al2){
            cnt2 += pnums[i];
        }

        ans = Math.min(ans, Math.abs(cnt1-cnt2));
    }
}

