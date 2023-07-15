import java.util.HashSet;

public class elementssum {
  public static void main(String[] args) {
    int[] element = {7,9,1,1,4};
   
    HashSet<Integer> set = new HashSet<>();
   
    //i는 얼마만큼의 길이인지
    for(int i=1; i<=element.length; i++){

      for(int j=0; j<element.length; j++){
        int sum = 0;

        for(int k=0; k<i; k++){
          if(j+k > element.length-1){
            sum+= element[j+k-element.length];
          }else sum += element[j+k];
        }

        set.add(sum);
      }

    }
    System.out.println(set.size());
  }
}
