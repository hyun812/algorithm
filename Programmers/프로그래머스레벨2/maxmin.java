
import java.util.Arrays;

//레벨2 - 최댓값과 최솟값
public class maxmin {
    public static void main(String[] args) {
        String s ="-1 -2 -3 -4";

        String[] sArray = s.split(" ");
        int[] iArray = new int[sArray.length];

        for(int i=0; i<sArray.length; i++){
            iArray[i] = Integer.parseInt(sArray[i]);
        }
        
        String answer = "";

        Arrays.sort(iArray);

        answer += iArray[0];
        answer += " ";
        answer += iArray[iArray.length-1];
        System.out.println(Arrays.toString(iArray));
        System.out.println(answer);
    }
}
