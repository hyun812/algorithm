import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

		Queue<Alpa> q = new ArrayDeque<>();
		q.add(new Alpa(begin, 0));
		
		boolean flag = false;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(target)) {
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			return 0;
		}
		
		while(!q.isEmpty()) {
			Alpa poll = q.poll();
			
			for(int i=0; i<words.length; i++) {
				String word = words[i];
				
				int cnt = 0;
				for(int j=0; j<word.length(); j++) {
					if(poll.word.charAt(j) == word.charAt(j)) {
						cnt++;
						continue;
					}
				}
				
				if(cnt == word.length()-1) {
					if(word.equals(target)) {
						return poll.len+1;
					}else {
						q.add(new Alpa(word, poll.len+1));
					}
				}
				
			}
		}
		return answer;
    }
    class Alpa {
		String word;
		int len;
		
		public Alpa(String word, int len) {
			super();
			this.word = word;
			this.len = len;
		}
	}
}