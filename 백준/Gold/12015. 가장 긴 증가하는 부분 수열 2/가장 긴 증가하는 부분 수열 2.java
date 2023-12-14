import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list.add(arr[0]);

		for(int i=1; i<n; i++) {
			
			int key = arr[i];
			
			if(key > list.get(list.size()-1)) { // 리스트의 마지막 요소보다 크면
				list.add(key);
			}else { // 리스트의 마지막 요소보다 작거나 같으면 
				int left = 0;
				int right = list.size()-1;
				int mid = 0;
				
				while(left < right) { // lower bounded로 진행
					mid = (left + right)/2;
					
					if(list.get(mid) < key) left = mid+1;
					else right = mid;
				}
				list.set(right, key);
			}
		}
//		System.out.println(list);
		System.out.println(list.size());
	}

}