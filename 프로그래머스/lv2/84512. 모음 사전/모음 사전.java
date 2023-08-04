import java.util.*;


class Solution {
    static char[] alphabets  = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        
    List<String> list = new ArrayList<>();
    for(int i=0; i<alphabets.length; i++){
      dfs(list, String.valueOf(alphabets[i]));
    }
        return list.indexOf(word)+1;
    }
    void dfs(List<String> list, String word){
    if(word.length() > 5) return;
    
    list.add(word);

    for(int i=0; i<alphabets.length; i++){
      dfs(list, word + alphabets[i]);  
    }
    
  }
}