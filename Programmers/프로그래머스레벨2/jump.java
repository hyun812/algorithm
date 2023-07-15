
public class jump {
    public static void main(String[] args) {
        long answer = 0;
        int n = 6;
        
        int count = 1;
        int r = 1;
        
        
        while(n > r){
            count += combination(n-1, r);
            r++;
            n--;
        }
        
        System.out.println(count);
        
    }

    public static int combination(int n , int r){
        if(n==r || r==0) return 1;
        return combination(n-1, r-1) + combination(n-1, r);
    }
}
