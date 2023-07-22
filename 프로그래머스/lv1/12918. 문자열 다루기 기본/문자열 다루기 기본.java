class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] c = s.toCharArray();
        //48 ~ 57

        if(s.length() == 4 || s.length() == 6){
            for(int i=0; i<c.length; i++){
                if((int)c[i] < 48 || (int)c[i] > 57){
                    answer = false;
                    break;
                }
            }
        }
        else{
            answer = false;
        }
        return answer;
    }
}