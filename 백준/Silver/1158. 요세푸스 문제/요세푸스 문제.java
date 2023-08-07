
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0; i<n; i++) {
        	queue.add(i+1);
        }
        
        sb.append("<");
        while(queue.size() !=1) {
        	
        	for(int i=0; i<m-1; i++) {
        		queue.add(queue.poll());	
        	}
        	
        	
    		sb.append(queue.poll()).append(", ");
        	
        }
        
        sb.append(queue.poll()).append(">");
        
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}