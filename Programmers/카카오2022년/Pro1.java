package 카카오2022년;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class Pro1 {
    
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        //28일
        HashMap<String, Integer> termss = new HashMap<>();

        for(String s : terms){
            termss.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1])*28);
        }
        System.out.println(termss);

        int tod = daycal(today);

        ArrayList<Integer> answers = new ArrayList<>();


        for(int i=0; i<privacies.length; i++){
            int a = daycal(privacies[i].split(" ")[0]);
            int term = tod - a;

            if(termss.get(privacies[i].split(" ")[1]) <= term){
                answers.add(i+1);
            }
        }

        int[] answer = new int[answers.size()];
        for(int i=0; i<answers.size(); i++){
            answer[i] = answers.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }

    public static int daycal(String d){
        int year = Integer.parseInt(d.split("[.]")[0]);
        int month = Integer.parseInt(d.split("[.]")[1]);
        int day = Integer.parseInt(d.split("[.]")[2]); 
        int tod = (year*28*12) +(month * 28)+ day ;

        return tod;
    }
}
