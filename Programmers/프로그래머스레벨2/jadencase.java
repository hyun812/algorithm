
import java.util.Arrays;

//레벨2 - JadenCase 문자열 만들기
public class jadencase {
    public static void main(String[] args) {
        String s = "3people   unFollowed   me     ";
        String answer = "";
        // String[] sA = s.split("");

        // String[] sArr = s.split(" ");
        // for(int i=0; i<sArr.length; i++){
        //     if(!sArr[i].equals("")){
        //         sArr[i] = sArr[i].substring(0,1).toUpperCase() + sArr[i].substring(1).toLowerCase();
        //     }
        // }
        
        // for(int i=0; i<sArr.length; i++){
        //     if(i != 0){
        //         answer += " ";
        //     }
        //     answer += sArr[i];
        // }
        // int len = sA.length;
        // int alen = answer.split("").length;

        // if(len != alen){
        //     for(int i=0; i<len-alen; i++){
        //         answer += " ";
        //     }
        // }

        // answer += "dd";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        System.out.println(answer);

    }
}
