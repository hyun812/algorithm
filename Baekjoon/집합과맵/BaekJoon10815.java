package 집합과맵;

import java.io.*;
import java.util.*;

public class BaekJoon10815 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Set<Integer> set = new HashSet<>();

    for(int i=0; i<N; i++){
      int num = Integer.parseInt(st.nextToken());
      set.add(num);
    }
    
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++){
      int num = Integer.parseInt(st.nextToken());
      if(set.contains(num)){
        bw.write("1 ");
      }else{
        bw.write("0 ");
      }
    }
    bw.flush();
    bw.close();
  }
}
