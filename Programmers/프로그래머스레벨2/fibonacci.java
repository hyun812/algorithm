
//레벨2- 피보나치 수
public class fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[n+1];
        
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        System.out.println(nums[n]);

    }
}