import java.util.*;
import java.io.*;

public class sw14692 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
      if(N%2 == 0){
        System.out.println("#"+test_case+" Alice");
      }else{
        System.out.println("#"+test_case+" Bob");
      }

		}
  }
}

