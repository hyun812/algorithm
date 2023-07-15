package 프로그래머스레벨1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//레벨1 - 크레인 인형뽑기 게임
public class dollgame {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        // 4 3 1 1 3 2 0 4
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
                // else{
                //     ck[j][moves[i]-1] = true;
                //     result.push(0);
                // }
            }
        }
        System.out.println(result);
        System.out.println(answer);
    }
}
