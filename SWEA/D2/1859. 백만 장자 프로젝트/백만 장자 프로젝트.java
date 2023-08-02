
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		 Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int i=0; i<T; i++){
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int j=0; j<N; j++){
				arr[j] = sc.nextInt();
 			}

			int max = 0;
			long result = 0;
			for(int j=N-1; j>=0; j--){
				if(arr[j] > max) max = arr[j];
				result += max-arr[j];
			}

			System.out.println("#" + (i+1) + " " + result);
		}
	}
}