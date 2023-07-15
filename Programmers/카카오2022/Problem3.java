package 카카오2022;

import java.util.Arrays;
import java.util.HashMap;

public class Problem3 {
    public static void main(String[] args) {
        int[] fees = new int[] {180, 5000, 10, 600};
        String[] records = new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        
        HashMap<String, Integer> car = new HashMap<>();
        HashMap<String, String> re = new HashMap<>();

        HashMap<String, Integer> result = new HashMap<>();

        for(String i : records){
            car.put(i.split(" ")[1], 0);
        }
        System.out.println(car);
        
        for(String i : records){
            String[] infos = i.split(" ");

            if(re.containsKey(i.split(" ")[1])){
                int intime = Integer.parseInt(re.get(infos[1]).split(":")[0])*60 +Integer.parseInt(re.get(infos[1]).split(":")[1]);
                int outtime = Integer.parseInt(infos[0].split(":")[0])*60 + Integer.parseInt(infos[0].split(":")[1]);

                int resulttime = outtime - intime;
                car.put(i.split(" ")[1], car.get(i.split(" ")[1]) + resulttime);

                re.remove(i.split(" ")[1]);
            }
            else{
                re.put(infos[1], infos[0]);
            }

        }
        System.out.println(car);

        for(String i : re.keySet()){
            int intime = Integer.parseInt(re.get(i).split(":")[0])*60 +Integer.parseInt(re.get(i).split(":")[1]);
            int outtime = 60*23 +59;
            
            int resulttime = outtime - intime;
            car.put(i, car.get(i)+resulttime);
        }
        System.out.println(car);

        //int[] fees = new int[] {180, 5000, 10, 600};
        //car = {0148=670, 0000=334, 5961=146}

        for(String i : car.keySet()){
            int basetime = fees[0];
            int basefee = fees[1];
            int unittime = fees[2];
            int unitfee =fees[3];

            if(car.get(i) <= basetime){
                result.put(i, basefee);
            }
            else{
                int fee = 0;
                if((car.get(i)-basetime)%unittime !=0){
                    fee = basefee + ((car.get(i)-basetime)/unittime+1)*unitfee;
                }
                else{
                    fee = basefee + (car.get(i)-basetime)/unittime*unitfee;
                }
                result.put(i, fee);
            }
        }
        System.out.println(result);

        Object[] arr = result.keySet().toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            answer[i] = result.get(arr[i]);
        }
        System.out.println(Arrays.toString(answer));
    }
}
