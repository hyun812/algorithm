class Solution {
    public int solution(int n) {
        int answer = 0;
        int i=1;
        
        while(i <= n/2){
            int start = i;
            int sum = 0;

            while(sum < n){
                sum += start;
                start++;
            }
            if(sum == n){
                answer++;
            }
            i++;
        }
        answer++;
        return answer;
    }
}