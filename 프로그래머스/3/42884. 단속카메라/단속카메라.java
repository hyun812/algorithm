import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int[][] routes) {
        ArrayList<Car> list = new ArrayList<>();

		for (int i = 0; i < routes.length; i++) {
			list.add(new Car(routes[i][0], routes[i][1]));
		}

		Collections.sort(list, (a, b) -> {
			return a.end - b.end;
		});
        
        return doit(list);
    }
    
    // 진입보다 크거나 같고 진출보다 작거나 같으면 카메라를 만난것
    // 진입 시점이랑 진출시점
    int doit(ArrayList<Car> list) { // cnt 카메라 개수

		int answer = 1;
		int last = list.get(0).end;
		
		for (int i = 1; i < list.size(); i++) {
			Car target = list.get(i);
			if ( target.start <= last && last <= target.end )
				continue;
			
			last = list.get(i).end; // 마지막 카메라 위치 저장
			answer++;
		}

		return answer;
	}
    
     class Car {
		int start, end;

		public Car(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Car [start=" + start + ", end=" + end + "]";
		}
	}
}