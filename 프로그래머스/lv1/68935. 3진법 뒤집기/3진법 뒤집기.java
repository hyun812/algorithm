class Solution {
    public int solution(int n) {
        int answer = 0;
        String answer_3 = Integer.toString(n,3);
        String reverse_3 = "";

        for(int i=answer_3.length()-1; i>=0; i--){
            reverse_3 += answer_3.charAt(i);
        }
        
        int count = 1;
        for(int i=reverse_3.length()-1; i>=0; i--){
            answer += Character.getNumericValue(reverse_3.charAt(i))*count;
            count = count*3;
        }
        
        return answer;
    }
}