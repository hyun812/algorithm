
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String[] arr;
	static boolean[] isSelected;
	static HashSet<String> hs;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		arr = bf.readLine().split("");
		n = arr.length;
		
		hs = new HashSet<>();
		isSelected = new boolean[n];
		
		
		for(int i=0; i<n; i++) {
			check(i);	
		}
		
		
		System.out.println(hs.size());
	}
	
	public static void check(int start) {
		
		String ans = "";
		for(int i=start; i<n; i++) {
			ans += arr[i];
			hs.add(ans);
		}
		
	}
}