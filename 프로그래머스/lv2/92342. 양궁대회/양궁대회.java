class Solution {
    static int max = 0;
    static int[] answer = { -1 };
    static int[] lion;
    static int cnt=0;
    
    public int[] solution(int n, int[] info) {
        lion = new int[11];
    
        dfs(info, n, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] info, int n, int cnt, int start){
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
                        if(lion[i] > answer[i]){
                            max = lion_point-apeach_point;
                            answer = lion.clone();
                            
                        }else if(lion[i] < answer[i])
                            return;
                    }
                }
                else if(Math.abs(lion_point-apeach_point) > max){
                    max = lion_point-apeach_point;
                    answer = lion.clone();
                }
            }
        }

        else{
            for(int i=start; i<11; i++){
                lion[i]++;
                dfs(info, n, cnt+1, i);
                lion[i]--;
            }
        }
    }
}