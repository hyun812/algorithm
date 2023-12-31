import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        HashMap<String, Integer> car = new HashMap<>();
        HashMap<String, String> re = new HashMap<>();

        HashMap<String, Integer> result = new HashMap<>();

        for(String i : records){
            car.put(i.split(" ")[1], 0);
        }
        
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
        
        Object[] arr = result.keySet().toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            answer[i] = result.get(arr[i]);
        }
        return answer;
    }
}