class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.replace(" ", "_");

        String[] sp = s.split("_");

        for(int i=0; i<sp.length; i++){

            for(int j=0; j<sp[i].split("").length; j++){
                if(j==0 || j%2 == 0){
                    answer += sp[i].split("")[j].toUpperCase();
                }
                else{
                    answer += sp[i].split("")[j].toLowerCase();
                }
            }
            if(i != sp.length-1){
                answer += "_";
            }
        }
for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '_'){
                answer += "_";
            }
            else{
                break;
            }
        }
        answer = answer.replace("_", " ");
        return answer;
    }
}