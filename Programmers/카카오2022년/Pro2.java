package 카카오2022년;

import java.util.HashMap;

public class Pro2 {
    public static void main(String[] args) {
        int cap = 1;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 7};
        int[] pickups = {0, 3, 0, 4, 5};
        int answer = 0;

        HashMap<Integer,Integer> deliver = new HashMap<>();
        HashMap<Integer,Integer> pickup = new HashMap<>();
        for(int i=0; i<deliveries.length; i++){
            if(deliveries[i] != 0){
                deliver.put(i+1, deliveries[i]);
            }
        }
        for(int i=0; i<pickups.length; i++){
            if(pickups[i] != 0){
                pickup.put(i+1, pickups[i]);
            }
        }
        
        System.out.println(deliver);
        System.out.println(pickup);

        while(!deliver.isEmpty() && !pickup.isEmpty()){
            int a = cap;
            int count1 =0;
            int count2 =0;
            int b = cap;

            for(int i=n; i>0; i--){
                if(deliver.containsKey(i)){
                    if(deliver.get(i) <= a){
                        int temp = deliver.get(i);
                        deliver.remove(i);
                        a = a-temp;
                        if(i > count1){
                            count1 = i;
                        }
                    }
                    else if(deliver.get(i) > a && a!=0){
                        deliver.replace(i, deliver.get(i)-a);
                        a = 0;
                        if(i > count1){
                            count1 = i;
                        }
                    }
                }
                
                if(pickup.containsKey(i)){
                    if(pickup.get(i) <= b){
                        int temp = pickup.get(i);
                        pickup.remove(i);
                        b = b-temp;
                        if(i > count2){
                            count2 = i;
                        }
                    }
                    //pickup.get(i) == 2 | b==1
                    else if(pickup.get(i) > b && b!=0){
                        pickup.replace(i, pickup.get(i)-b);
                        b = 0;
                        if(i > count2){
                            count2 = i;
                        }
                    }
                }
            }
            if(count1 < count2){
                answer += count2 *2;
            }
            else{
                answer += count1 *2;
            }
            System.out.println(deliver);
            System.out.println(pickup);
        }    
        System.out.println(answer);
    }
}
