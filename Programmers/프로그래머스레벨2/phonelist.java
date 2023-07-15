import java.util.Arrays;

public class phonelist {
  public static void main(String[] args) {
    String[] phone_book = {"119", "97674223", "1195524421"};
    boolean answer = true;
    
    // Arrays.sort(phone_book, (String s1, String s2) -> s1.length() - s2.length());
    Arrays.sort(phone_book);
    System.out.println(Arrays.toString(phone_book));
    for(int i=0;i<phone_book.length-1;i++){
      if(phone_book[i+1].startsWith(phone_book[i])){
          answer = false;
          break;
      }
  }

    
  }  
}
