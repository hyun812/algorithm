
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hm = new HashMap<>();
		ArrayList<String> al = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String noli = bf.readLine();
			hm.put(noli, 1);
		}
		
		for(int i=0; i<m; i++) {
			String nose = bf.readLine();
			if(hm.get(nose) != null) {
				al.add(nose);
			}
		}
		
		
		Collections.sort(al);
		
		System.out.println(al.size());
		for(String s : al) {
			System.out.println(s);
		}
		
	}
}