import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String target = bf.readLine();
		
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<arr.length; i++) {
			if(target.contains(arr[i])) {
				target = target.replace(arr[i], "?");
			}
		}
		int result = target.length();
		
		
		System.out.println(result);
	}
}
