import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
      String answer = "";
        m = change(m);

    LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
    for(int i=0; i<musicinfos.length; i++){
      String start = musicinfos[i].split(",")[0];
      String end = musicinfos[i].split(",")[1];
      String title = musicinfos[i].split(",")[2];
      String info = musicinfos[i].split(",")[3];
      
      int startTime = Integer.parseInt((start.split(":")[0]))*60 + Integer.parseInt(start.split(":")[1]);
      int endTime = Integer.parseInt((end.split(":")[0]))*60 + Integer.parseInt(end.split(":")[1]);
      int play = endTime-startTime; // 14

      info = change(info);
      int idx = 0;
      String value = "";
      
      while(play!=0){
        if(idx == info.length()) idx = 0;
        value += info.charAt(idx);
        idx++;
        play--;
      }
      System.out.println(value);
      hm.put(title, value);
    }
    int len = 0;
    for(String s : hm.keySet()){
      if(hm.get(s).contains(m) && len < hm.get(s).length()){
        answer = s;
        len = hm.get(s).length();
      }
    }
        return len != 0 ? answer : "(None)";
    }
    
    public String change(String m){
    m = m.replaceAll("C#", "H");
    m = m.replaceAll("D#", "I");
    m = m.replaceAll("F#", "J");
    m = m.replaceAll("G#", "K");
    m = m.replaceAll("A#", "L");
    
    return m;
  }
    
}