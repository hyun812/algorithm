import java.util.Arrays;

public class price {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer = new int[prices.length];

        int idx = 0;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j]){
                    answer[idx++] = j-i;
                    break;
                }
                if(j == prices.length-1){
                    answer[idx++] = j-i;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
