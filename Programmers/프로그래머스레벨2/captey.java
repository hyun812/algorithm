
import java.util.Arrays;

//레벨2 - 카펫
public class captey {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] answer = new int[2];

        int i=1;
        while(true){
            int width = Math.max(i, yellow/i);
            int height = Math.min(i, yellow/i);
            if(width * height == yellow){
                if((width+2)*2 + (height*2) == brown){
                    answer[0] = width+2;
                    answer[1] = height+2;
                    break;
                }
                else i++;
            }
            else i++;
        }
        
        System.out.println(Arrays.toString(answer));
    }
}
