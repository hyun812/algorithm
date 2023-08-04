import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<Character>();
    for(int i=0; i<skill_trees.length; i++){
      for(int k=0; k<skill.length(); k++){
        queue.add(skill.charAt(k));
      }

      if(check(skill_trees[i], queue)){
        answer++;
      }
      queue.clear();
    }
        return answer;
    }
    public boolean check(String skill, Queue<Character> queue){
    for(int i=0; i<skill.length(); i++){
      char target = skill.charAt(i);
      if(queue.contains(target)){
          Character q = queue.poll();
        if(!q.equals(target)) return false;
      }
    }

    return true;
  }
}