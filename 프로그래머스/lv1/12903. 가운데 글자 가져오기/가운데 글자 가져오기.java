class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cs = s.toCharArray();
        int length = s.length();

        if(length % 2 ==0){
            answer = String.valueOf(cs[length/2-1]) + String.valueOf(cs[length/2]);
        }
        else{
            answer = String.valueOf(cs[length/2]);
        }
        return answer;
    }
}