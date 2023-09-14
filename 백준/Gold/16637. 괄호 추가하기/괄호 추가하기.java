import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans = Integer.MIN_VALUE;
    static ArrayList<Integer> num;
    static ArrayList<String> op;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        num = new ArrayList<>();
        op = new ArrayList<>();

        String[] line = bf.readLine().split("");

        num.add(Integer.parseInt(line[0]));
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                num.add(Integer.parseInt(line[i]));
            } else {
                op.add(line[i]);
            }
        }
        dfs(0, num.get(0));
        System.out.println(ans);
    }


    private static void dfs(int idx, int sum) {
        if (idx >= op.size()) {
            ans = Math.max(sum,ans);
            return;
        }

        // 1 괄호 안치기
        dfs(idx + 1, cal(idx, sum, num.get(idx+1)));
        // 2 괄호 치기
        if(idx+1 < op.size()){
            int one = cal(idx+1, num.get(idx+1), num.get(idx+2));
            dfs(idx+2, cal(idx, sum, one));
        }
    }

    private static int cal(int idx, int a, int b){
        int calc = 0;
        switch (op.get(idx)){
            case "+" :
                calc = a+b;
                break;
            case "-" :
                calc = a-b;
                break;
            case "*" :
                calc = a*b;
                break;
        }
        return calc;
    }
}