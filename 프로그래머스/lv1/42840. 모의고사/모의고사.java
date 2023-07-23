import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int a_count =0;
        int b_count =0;
        int c_count =0;

        int a_index = 0;
        int b_index = 0;
        int c_index = 0;

        for(int i=0; i<answers.length; i++){
            if(a_index > 4){
                a_index = 0;
            }
            if(a[a_index] == answers[i]){
                a_count++;
            }
            a_index++;
        }
        
        for(int i=0; i<answers.length; i++){
            if(b_index > 7){
                b_index = 0;
            }
            if(b[b_index] == answers[i]){
                b_count++;
            }
            b_index++;
        }

        for(int i=0; i<answers.length; i++){
            if(c_index > 9){
                c_index = 0;
            }
            if(c[c_index] == answers[i]){
                c_count++;
            }
            c_index++;
        }
        int max = Math.max(Math.max(a_count, c_count), b_count);
        List<Integer> result = new ArrayList<>();


        // answer = Arrays.stream(answer).filter(f -> f != max).
        
        if(max == a_count){
            result.add(1);
        }
        if(max == b_count){
            result.add(2);              
        }
        if(max == c_count){
            result.add(3);
        }

        int[] answer = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i).intValue();
        }
        return answer;
    }
}