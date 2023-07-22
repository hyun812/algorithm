class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = 0;
        int b = 0;
        
        if(Math.max(m, n) % Math.min(m, n) == 0){
            a = Math.min(m, n);
        }else{
            for(int i=Math.min(m, n); i>=1; i--){
                if(m%i == 0 && n%i == 0){
                    a = i;
                    break;
                }
            }
        }
        
        if(a==1){
            b=m*n;
        }
        else if(a == m ){
            b = n;
        }
        else if(a== n){
            b = m;
        }
        else{
            b =m*n/a;
        }
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}