import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Main
 */

public class Main {
    static ArrayList<int[]> steps;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        steps = new ArrayList<>();
        
        BigInteger bi = new BigInteger("2");
        BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
        System.out.println(c);
        if(n <= 20){
            hanoi(n, 1, 2, 3);

            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                System.out.println(step[0] + " " + step[1]);
            }
        }
        
    }

    public static void hanoi(int cnt, int from , int via, int to) {
        
        if(cnt == 1){
            steps.add(new int[] {from, to});
        }
        // n-1하노이만큼을 via로 옮기고 n을 to으로 옮기고 via에있는걸 to으로 옮김
        else{
            hanoi(cnt-1, from, to, via);
            steps.add(new int[] {from , to});
            hanoi(cnt-1, via, from, to);
        }
        
    }   
}