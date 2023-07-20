import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArray = s.split(" ");
        int[] iArray = new int[sArray.length];

        for(int i=0; i<sArray.length; i++){
            iArray[i] = Integer.parseInt(sArray[i]);
        }
    

        Arrays.sort(iArray);

        answer += iArray[0];
        answer += " ";
        answer += iArray[iArray.length-1];
        return answer;
    }
}