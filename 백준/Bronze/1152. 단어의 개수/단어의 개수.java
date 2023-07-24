
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String result = sc.nextLine();
    	
    	int answer = 0;
    	
    	String[] arr = result.split(" ");
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i].equals("")) continue;
    		answer++;
    	}
    	
    	System.out.println(answer);
    }
}