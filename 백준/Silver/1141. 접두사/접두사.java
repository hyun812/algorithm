import java.io.*;
import java.util.*;

public class Main {

	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		String[] arr = new String[n];
		HashSet<String> hs = new HashSet<String>();
		
		
		for(int i=0; i<n; i++) {
			String target = bf.readLine();
			arr[i] = target;
		}
		Arrays.sort(arr, (o1, o2) ->{
			return o2.length()-o1.length();
		});
		
		
		for(String s : arr) {
			if(hs.size() == 0) {
				hs.add(s);
				continue;
			}
			
			boolean flag = true;
			for(String target : hs) {
				if(target.indexOf(s) == 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				hs.add(s);
			}
		}
		
		System.out.println(hs.size());
	}

}