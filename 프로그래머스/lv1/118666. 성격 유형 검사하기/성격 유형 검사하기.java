import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String ss = "RTCFJMAN";
int score[] = new int[8];
        HashMap<String, Integer> point = new HashMap<>();
        
        for(String s : ss.split("")){
            point.put(s, 0);
        }
        
        for(int i=0; i<choices.length; i++){
            if(choices[i] > 4){
                point.put(survey[i].split("")[1], point.get(survey[i].split("")[1])+choices[i] -4);
            }
            if(choices[i] < 4){
                point.put(survey[i].split("")[0], point.get(survey[i].split("")[0])+4-choices[i]);
            }
        }
        
        for(int i=0; i<score.length; i++){
            score[i] = point.get(ss.split("")[i]);
        }
        
        
        for(int i=0; i<score.length; i+=2){
            if(score[i] >= score[i+1]){
                answer += ss.split("")[i];
            }
            else answer += ss.split("")[i+1];
        }
        return answer;
    }
}