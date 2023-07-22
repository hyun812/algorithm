class Solution {
    public String solution(int n) {
        String answer = "";
        boolean check = true;
        
        while(true){
            if(n==0){
                break;
            }
            else{
                if(check){
                    answer += "수";
                    check = false;
                    n--;
                }
                else{
                    answer += "박";
                    check = true;
                    n--;
                }
            }
        }
        
        return answer;
    }
}