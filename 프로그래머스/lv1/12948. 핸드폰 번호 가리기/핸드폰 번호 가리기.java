class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String s = "";
        
        for(int i=0; i<phone_number.length()-4; i++){
            s += "*";
        }
        phone_number = phone_number.substring(phone_number.length()-4, phone_number.length());

        answer = s + phone_number;
        return answer;
    }
}