package 카카오2022;

import java.util.Arrays;

public class Problem4 {
    static int max = 0;
    static int[] res = { -1 };
    static int[] lion;
    static int[] info = new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
    static int cnt=0;
    public static void main(String[] args) {
        int n =9;
        lion = new int[11];

        dfs(n, 0, 0);

        System.out.println(Arrays.toString(res));
    }

    public static void dfs(int n, int cnt, int start){
        if(n == cnt){
            //점수계산
            int lion_point = 0;
            int apeach_point = 0;

            for(int i=0; i<11; i++){
                if(lion[i] > info[i]){
                    lion_point += 10-i;
                }
                else if(lion[i] <= info[i] && info[i] !=0){
                    apeach_point += 10-i;
                }
            }
            if(lion_point > apeach_point){
                if(Math.abs(lion_point-apeach_point) == max){
                    for(int i=10; i>=0; i--){
                        if(lion[i] > res[i]){
                            max = lion_point-apeach_point;
                            res = lion.clone();     
                               
                        }else if(lion[i] < res[i]){
                            
                            return;
                        }
                    }
                }
                else if(Math.abs(lion_point-apeach_point) > max){
                    max = lion_point-apeach_point;
                    res = lion.clone();
                }
            }
        }

        else{
            for(int i=start; i<11; i++){
                lion[i]++;
                dfs(n, cnt+1, i);
                lion[i]--;

            }
        }
    }
}