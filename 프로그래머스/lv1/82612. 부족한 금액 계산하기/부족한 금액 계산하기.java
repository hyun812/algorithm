class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sumprice = 0;
        
        for(int i=1; i<=count; i++){
            sumprice += i*price;
        }
        if(sumprice - money > 0){
            answer = sumprice - money;
        }
        else answer = 0;
        return answer;
    }
}