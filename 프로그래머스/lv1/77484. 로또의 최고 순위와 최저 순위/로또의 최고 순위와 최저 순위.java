class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count =0;
        int zero_count =0;
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    count++;
                }
            }
        }

        for(int i=0; i<6; i++){
            if(lottos[i] == 0){
                zero_count++;
            }
        }

        answer[0] = 7-count-zero_count;
        answer[1] = 7-count;
        if(answer[0] > 6){
            answer[0] = 6;
        }
        if(answer[1] > 6){
            answer[1] = 6;
        }
        return answer;
    }
}