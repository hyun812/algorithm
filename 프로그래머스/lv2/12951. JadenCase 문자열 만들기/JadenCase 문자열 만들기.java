class Solution {
    public String solution(String s) {
        String answer = "";
         String[] sA = s.split("");

        String[] sArr = s.split(" ");
        for(int i=0; i<sArr.length; i++){
            if(!sArr[i].equals("")){
                sArr[i] = sArr[i].substring(0,1).toUpperCase() + sArr[i].substring(1).toLowerCase();
            }
        }
        
        for(int i=0; i<sArr.length; i++){
            if(i != 0){
                answer += " ";
            }
            answer += sArr[i];
        }
        int len = sA.length;
        int alen = answer.split("").length;

        if(len != alen){
            for(int i=0; i<len-alen; i++){
                answer += " ";
            }
        }
        return answer;
    }
}