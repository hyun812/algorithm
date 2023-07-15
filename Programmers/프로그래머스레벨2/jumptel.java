
public class jumptel {
    public static void main(String[] args) {
        int n = 5000;
        int ans = 0;
        
        
        while(n != 1){
            if(n%2 == 0){
                n = n/2;
                
            }
            else{
                n = n-1;
                ans++;
            }
        }

        ans++;

        System.out.println(ans);
    }
}
