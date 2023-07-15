import java.util.Arrays;

public class h_index {
  public static void main(String[] args) {
    int[] citations = {0,1,2};
    int result = 0;

    Arrays.sort(citations);
    // 0 1 3 5 6 
    //적거나 같아지는순간
    
    while(true){
      int temp = 0;
      for(int i=0; i<citations.length; i++){
        if(citations[i] >= result){
          temp++;
        }
      } 
      if(result == temp) break;
      if( result > temp) {
        result--; 
        break;
      }
      else result++;
      
    }
    
    System.out.println(result);
    
  }
}
