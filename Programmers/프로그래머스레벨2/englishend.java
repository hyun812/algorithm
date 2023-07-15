
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//레벨2 - 영어 끝말잇기
public class englishend {
    public static void main(String[] args) {
        int n =2;
        String[] words = {"land", "dream", "mom", "mom", "ror"};
        int[] answer = new int[2];

        int sameindex = 101;
        int xindex = 101;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            if(set.contains(words[i])){
                sameindex = i;
                break;
            }
            else{
                set.add(words[i]);
            }
        }

        for(int i=0; i<words.length-1; i++){
            int last = words[i].length()-1;
            
            if(words[i].charAt(last) != words[i+1].charAt(0)){
                xindex = i+1;
                break;
            }
        }

        int index = Math.min(sameindex, xindex);
        if(index != 101){
            if((index+1)%n == 0){
                answer[0] = n;
                answer[1] = ((index+1)/n);
            }
            else {
                answer[0] = (index+1)%n;
                answer[1] = ((index+1)/n+1);
            }
        }
        else{
            answer[0] = 0;
            answer[1] = 0;
        }

        System.out.println(Arrays.toString(answer));
    }
}
