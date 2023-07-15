package 프로그래머스레벨1;

import java.util.Arrays;
import java.util.HashMap;

//레벨1 - 숫자짝꿍
public class pairnum {
    public static void main(String[] args) {
        String X = "100";
        String Y = "123450";

        String answer = "";
        StringBuilder sb = new StringBuilder(answer);

        HashMap<String, Integer> x_hash = new HashMap<>();
        HashMap<String, Integer> y_hash = new HashMap<>();

        for(int i=0; i<10; i++){
            x_hash.put(Integer.toString(i), 0);
            y_hash.put(Integer.toString(i), 0);
        }

        for(String i : X.split("")){
            x_hash.put(i, x_hash.get(i)+1);
        }

        for(String i : Y.split("")){
            y_hash.put(i, y_hash.get(i)+1);
        }

        for(String i : x_hash.keySet()){
            if(x_hash.get(i) != 0 && y_hash.get(i) !=0){
                int a = Math.min(x_hash.get(i), y_hash.get(i));
                for(int k=0; k<a; k++){
                    sb.append(i);
                }
            }
        }

        if(sb.toString().equals("")){
            sb.append(-1);
        }
        else{
            char[] chararr = sb.toString().toCharArray();
            Arrays.sort(chararr);
            answer = new StringBuilder(new String(chararr)).reverse().toString();
            if(answer.charAt(0) == '0'){
                sb.setLength(0); 
                sb.append(0);
            }
            else{
                sb.setLength(0); 
                sb.append(answer);
            }
        }
        System.out.println(x_hash);
        System.out.println(y_hash);
        System.out.println(sb.toString());
    }
}
