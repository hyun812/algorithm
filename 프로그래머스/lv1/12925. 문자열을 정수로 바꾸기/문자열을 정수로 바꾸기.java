class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] ss = s.split("");
        
        if(ss[0] == "+"){
            for(int i=1; i<ss.length; i++){
                s += ss[i];
            }
            
        }
        if(ss[0] == "-"){
            for(int i=1; i<ss.length; i++){
                s += ss[i];
            }
            answer = Integer.parseInt(s)*(-1);
        }
        else answer = Integer.parseInt(s); 
        return answer;
    }
}