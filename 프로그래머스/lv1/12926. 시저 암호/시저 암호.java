class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] c = s.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i] == ' '){
                answer += " ";
            }
            else if((int)c[i]+n > 122){
                answer += (char)(c[i]+n-26);
            }
            else if((int)c[i]+n > 90 && (int)c[i] < 97){
                answer += (char)(c[i]+n-26);
            }
            else{
                answer += (char)(c[i]+n);
            }
        }
        return answer;
    }
}