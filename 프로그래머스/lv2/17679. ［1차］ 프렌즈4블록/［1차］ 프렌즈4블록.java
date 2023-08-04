import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static boolean bd_ck[][];
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] bd = new String[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                bd[i][j] = board[i].split("")[j];
            }
        }
        
        boolean flag = true;
        while(flag){
            bd_ck = new boolean[m][n];
            flag = false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(bd[i][j].equals("#")) continue;
                    if(check(i,j,bd)){
                        bd_ck[i][j] = true;    
                        bd_ck[i][j+1] = true;
                        bd_ck[i+1][j] = true;
                        bd_ck[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            answer += drop(m, n, bd);
            bd_ck = new boolean[m][n];
        }
        return answer;
    }
    public static boolean check(int i, int j, String[][] bd){
        String s = bd[i][j];
        if(s.equals(bd[i][j+1]) && s.equals(bd[i+1][j]) && s.equals(bd[i+1][j+1])){
            return true;
        }
        return false;
    }

    public static int drop(int m, int n, String[][] bd){
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(bd_ck[i][j]){
                    bd[i][j] = ".";
                }
            }
        }

        //m=4 , n=5
        for(int i=0; i<n; i++){
            Queue<String> stack = new LinkedList<>();
            for(int j=m-1; j>=0; j--){
                if(bd[j][i].equals(".")){
                    cnt++;
                }
                else{
                    stack.add(bd[j][i]);
                }
            }
            int idx = m-1;

            while(!stack.isEmpty()){
                bd[idx][i] = stack.poll();
                idx--;
            }
            
            for(int k=idx; k>=0; k--){
                bd[k][i] = "#";
            }
        }
        return cnt;
    }
}