import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        boolean[][] ck = new boolean[board.length][board.length];
        
        int answer = 0;

        Stack<Integer> result = new Stack<>();

        //ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                int target = board[j][moves[i]-1];
                if(target == 0) {
                    ck[j][moves[i]-1] = true; 
                    continue;
                }

                if(!ck[j][moves[i]-1]){
                    ck[j][moves[i]-1] = true;
                    if(result.isEmpty()){
                        result.push(target);
                        
                    }
                    else{
                        int last = result.pop();
                        if(last != target){
                            result.push(last);
                            result.push(target);
                        }
                        else{
                            answer = answer+2;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}