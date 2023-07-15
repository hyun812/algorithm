package 프로그래머스레벨1;
import javax.swing.plaf.TreeUI;

//레벨 1 - 소수 만들기
public class Sosu {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int answer = 0;

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    boolean check = sosuCheck(sum);            
                    if(check == true){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static boolean sosuCheck(int num){
        for(int i=2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
