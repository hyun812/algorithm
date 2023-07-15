import java.util.*;

public class word {
  static char[] alphabets  = {'A', 'E', 'I', 'O', 'U'};
  public static void main(String[] args) {
    String word = "AAAAE";
    int answer = 0;
        
    List<String> list = new ArrayList<>();
    for(int i=0; i<alphabets.length; i++){
      dfs(list, String.valueOf(alphabets[i]));
    }

    System.out.println(list.indexOf(word)+1);
  }

  static void dfs(List<String> list, String word){
    if(word.length() > 5) return;
    
    list.add(word);

    for(int i=0; i<alphabets.length; i++){
      dfs(list, word + alphabets[i]);  
    }
    
  }
}
