package 카카오2022년;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Pro3 {
    public static void main(String[] args) {
        int[][] users = {{40,2900}, {23,10000}, {11,5200}, {5,5900}, {40,3100}, {27,9200}, {32,6900}};
        int[] emoticons = {1300,1500,1600,4900};
        int[] result = new int[2];
        //이모티콘의 모든 가격의 합에 최소 할인율을 적용 한게 사용자 최대금액보다 크면
        //이 사용자는 이모티콘 플러스 서비스를 무조건 o
        //이걸로 result의 첫번쨰 인덱스 값 구해짐
        HashMap<Integer, Integer> userprice = new HashMap<>();
        HashMap<Integer, Integer> userprice2 = new HashMap<>();
        int sumEmoPrice = 0;

        for(int i=0; i<emoticons.length; i++){
            sumEmoPrice += emoticons[i];
        }
        int point_idx = 0;
        
        for(int i=0; i<users.length; i++){
            if(users[i][1] <= cal((users[i][0]+9)/10*10, sumEmoPrice)){
                int dis = cal((users[i][0]+9)/10*10, sumEmoPrice)-users[i][1];
                result[0]++;
                userprice.put(i, dis);
            }
            else userprice2.put(i, 0);
        }
        System.out.println(result[0]);
        int minvalues = Collections.min(userprice.values());
        for(int i : userprice.keySet()){
            if(userprice.get(i) == minvalues){
                point_idx = i;
                break;
            }
        }
        System.out.println(userprice);
        System.out.println(userprice2);
        System.out.println(point_idx);
        System.out.println(minvalues);
        
        //cal((users[i][0]+9)/10*10, sumEmoPrice)
        //{11,5200}
        //가격이 작은거부터 할인율 구함
        int minper = (users[point_idx][0]+9)/10*10;
        emoticons = Arrays.stream(emoticons).sorted().toArray();
        
        HashMap<Integer, Integer> imper = new HashMap<>();
        for(int i=0; i<emoticons.length; i++){
            imper.put(emoticons[i], minper);
        }
        System.out.println(imper);
        System.out.println(Arrays.toString(emoticons));
        for(int i=emoticons.length; i>=0; i--){

        }

    }
    public static int cal(int percent, int price){
        return price*(100-percent)/100;
    }

    public static int allcal(HashMap<Integer,Integer> persent, int a){
        return a;
    }
    
}
