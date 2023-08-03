
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			String s = st.nextToken();
			int num = 0;
			if(!s.equals("all") && !s.equals("empty")) {
				num = Integer.parseInt(st.nextToken());	
			}
			 
			
			switch(s) {
			case "add" :
				if(!al.contains(num)) {
					al.add(num);	
				}
				break;
			case "remove" :
				if(al.contains(num)) {
					al.remove(Integer.valueOf(num));
				}
				break;
			case "check" :
				if(!al.contains(num)) {
					sb.append(0).append("\n");	
				}else {
					sb.append(1).append("\n");
				}
				break;
			case "toggle" :
				if(al.contains(num)) {
					al.remove(Integer.valueOf(num));
				}else {
					al.add(num);
				}
				break;
			case "all" :
				al.clear();
				for(int j=1; j<=20; j++) {
					al.add(j);
				}
				break;
			case "empty" :
				al.clear();
				break;
			}
		}
		System.out.println(sb);
	}

}
