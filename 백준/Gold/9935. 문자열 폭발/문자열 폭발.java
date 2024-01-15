import java.io.*;
import java.util.*;

public class Main {
	static String st, boom;
	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		st = bf.readLine();
		boom = bf.readLine();
		answer = "";
		
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < st.length(); i++) {
			char target = st.charAt(i);
			stack.add(target);

			if (stack.size() >= boom.length()) {
				boolean flag = true;

				for (int j = 0; j < boom.length(); j++) {
					if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < boom.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			for(char ch : stack) {
				sb.append(ch);
			}
			
			System.out.println(sb.toString());
		}

		
	}
}