class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String all = "";

        for(int i=0; i<t*m; i++){
            all += Integer.toString(i,n);
        }

        if(m==p){
            p=0;
        }
        for(int i=0; i<all.length(); i++){
            
            if(answer.length() == t){
                break;
            }
            if((i+1)%m == p){
                answer += all.charAt(i);
            }
        }
        return answer.toUpperCase();
    }
}