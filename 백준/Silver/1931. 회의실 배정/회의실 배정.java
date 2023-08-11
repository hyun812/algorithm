
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		List<int[]> time = new ArrayList<>();
		int result = 1;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			time.add(new int[] {start, end});
		}
		
		time.sort((o1, o2) -> {
			if(o1[1] != o2[1]) {
				return o1[1]-o2[1];
			}else{
				return o1[0]-o2[0];
			}
		});

      
        int endtime = time.get(0)[1];
       
        
        // i는 시작 시간
        // hm.get(i)는 종료시간
        for(int i=1; i<time.size(); i++) {
        	if(endtime > time.get(i)[0]) continue;
        	
        	endtime = time.get(i)[1];
        	result++;
        }
        
        System.out.println(result);
        
        
	}

	
}
