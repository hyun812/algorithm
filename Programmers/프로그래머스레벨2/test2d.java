import java.util.*;

public class test2d {
  static int[] nums = {1,2,3,4};
  static ArrayList<Integer[]> arr = new ArrayList<>();
  public static void main(String[] args) {

    

    // for(int i=1; i<nums.length; i++){
      ArrayList<Integer> tmp = new ArrayList<>();
      // combi(tmp,0, 0, i);  

      perm(tmp, 0, 4);
    // }
  }

  static public void combi(ArrayList<Integer> tmp, int idx, int cnt, int n){
    if(cnt ==n){
      System.out.println(tmp);
      return;
    }
    else{
      for(int i=idx; i<nums.length; i++){
        tmp.add(nums[i]);
        combi(tmp, i+1, cnt+1, n);
        tmp.remove(tmp.size()-1);
      }
    }
  }

  static public void perm(ArrayList<Integer> tmp, int cnt, int n){
    if(cnt ==n){
      System.out.println(tmp);
      return;
    }
    else{
      for(int i=0; i<nums.length; i++){
        if(tmp.contains(nums[i])) continue;
        tmp.add(nums[i]);
        perm(tmp, cnt+1, n);
        tmp.remove(tmp.size()-1);
      }
    }
  }
}
