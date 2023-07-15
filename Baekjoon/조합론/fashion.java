package 조합론;

import java.util.*;
public class fashion {

  static int result = 0;
  static int[] nums;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    nums = new int[N];

    for(int i=0; i<N; i++){
      nums[i] = i;  
    }

    ArrayList<Integer> arr = new ArrayList<>();
    perm(arr, 0, N);

    System.out.println(result);
  }

  static public void perm(ArrayList<Integer> arr, int cnt, int N){
    if(cnt == 2){
      result++;
      return;
    }else{
      for(int i=0; i<nums.length; i++){
        if(arr.contains(nums[i])) continue;
        arr.add(nums[i]);
        perm(arr, cnt+1, N);
        arr.remove(arr.size()-1);
      }
    }
  }

}