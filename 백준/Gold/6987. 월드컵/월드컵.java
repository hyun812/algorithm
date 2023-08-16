

import java.io.*;
import java.util.*;

public class Main {
	static int[][] score;
	static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int tc=0; tc<4; tc++) {
        	int total = 0;
        	st = new StringTokenizer(bf.readLine());
        	score = new int[6][3];
        	
        	for(int i=0; i<6; i++) {
        		for(int j= 0; j<3; j++) {
        			int num = Integer.parseInt(st.nextToken());
        			score[i][j] = num;
        			total += num;
        		}
            }
        	
        	if(total > 30) {
    			System.out.print(0+" ");
    			continue;
    		}
        	
        	if(play(0)) System.out.print(1+" ");
        	else System.out.print(0+" ");
        	
        }
    }
    
    private static boolean play(int game) {
    	
    	if(game == 15) return true;
    	
    	// 승 패
    	if(score[team1[game]][0] > 0 && score[team2[game]][2] > 0) {
    		score[team1[game]][0]--;
    		score[team2[game]][2]--;
    		if(play(game+1)) return true;
    		score[team1[game]][0]++;
    		score[team2[game]][2]++;
    	}
    	
    	// 무 무
    	if(score[team1[game]][1] > 0 && score[team2[game]][1] > 0) {
    		score[team1[game]][1]--;
    		score[team2[game]][1]--;
    		if(play(game+1)) return true;
    		score[team1[game]][1]++;
    		score[team2[game]][1]++;
    	}
    	
    	
    	// 패 승
    	if(score[team1[game]][2] > 0 && score[team2[game]][0] > 0) {
    		score[team1[game]][2]--;
    		score[team2[game]][0]--;
    		if(play(game+1)) return true;
    		score[team1[game]][2]++;
    		score[team2[game]][0]++;
    	}
    	
    	return false;
    	
    }   
}


