class Solution {
    boolean solution(String s) {
        boolean answer = true;
s = s.toLowerCase();

        char[] cs = s.toCharArray();
     
        int p_count = 0;
        int y_count = 0;

        for(int i=0; i<cs.length; i++){
            if(cs[i] == 'p'){
                p_count++;
            }
            if(cs[i] == 'y'){
                y_count++;
            }
        }

        if(p_count != y_count){
            answer = false;
        }

        return answer;
    }
}