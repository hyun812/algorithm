package 프로그래머스레벨1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//레벨1 - 완주하지 못한 선수
public class Maraton {
    public static void main(String[] args) {
        String[] participant ={"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);

        System.out.println(Arrays.toString(participant));
        System.out.println(Arrays.toString(completion));

        for(int i=0; i<completion.length; i++){
            if(participant[i] != completion[i]){
                answer = participant[i];
                break;
            }
            if(i==completion.length-1){
                answer = participant[i+1];
            }
        }
        System.out.println(answer);
    }
}
