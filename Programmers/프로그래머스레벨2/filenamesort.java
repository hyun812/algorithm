import java.util.*;

public class filenamesort {
  public static void main(String[] args) {
    String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
    
    Arrays.sort(files, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        String head1 = o1.split("[0-9]")[0];
        String head2 = o2.split("[0-9]")[0];
        int compareHead = head1.toUpperCase().compareTo(head2.toUpperCase());

        if(compareHead == 0) {
          o1 = o1.substring(head1.length());
          o2 = o2.substring(head2.length());
          String number1 = "";
          for(char c : o1.toCharArray()){
            if(Character.isDigit(c) && number1.length() <=5){
              number1 += c;
            }
            else break;
          }
          String number2 = "";
          for(char c : o2.toCharArray()){
            if(Character.isDigit(c) && number2.length() <=5){
              number2 += c;
            }
            else break;
          }
          return Integer.parseInt(number1) - Integer.parseInt(number2);
        }else {
          return compareHead;
        }
      }
    });

    System.out.println(Arrays.toString(files));
    // for(int i=0; i<NUMBER.length; i++){
    //   for(int j=0; j<NUMBER[i].length(); j++){
    //     if()
    //   }
    // }
    

  }
}
