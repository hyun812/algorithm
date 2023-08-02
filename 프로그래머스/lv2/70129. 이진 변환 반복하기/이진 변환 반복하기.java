class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;

        while(!s.equals("1")){
            int s_len = s.length();
            s = s.replace("0", "");
            zero += s_len-s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }

        
        answer[0] = count;
        answer[1] = zero;
        return answer;
    }
}