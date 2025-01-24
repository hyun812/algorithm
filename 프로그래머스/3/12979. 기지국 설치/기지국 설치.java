class Solution {
    public int solution(int n, int[] stations, int w) {
        		
        int answer = 0;
        int range = w * 2 + 1;

		int size = 0;
		int rightIndex = 0;

		for (int i = 0; i < stations.length; i++) {
			int target = stations[i];

			size = target - rightIndex - 1 - w;
			rightIndex = target + w;

            if(size <= 0) continue;

			int res = size % range != 0 ? size / range + 1 : size / range;
			answer += res;
		}

		if (rightIndex <= n) {
			size = n - rightIndex;
			int res = size % range != 0 ? size / range + 1 : size / range;
			answer += res;
		}
        return answer;
    }
}