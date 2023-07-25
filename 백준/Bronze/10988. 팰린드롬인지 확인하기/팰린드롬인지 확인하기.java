
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String target = bf.readLine();
		
		String rev = "";
		for(int i=target.length()-1; i>=0; i--) {
			rev += target.split("")[i];
		}
		
		if(rev.equals(target)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
}
