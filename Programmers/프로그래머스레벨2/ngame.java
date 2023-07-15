
public class ngame {
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;

        String answer = "";
        String all = "";

        for(int i=0; i<t*m; i++){
            all += Integer.toString(i,n);
        }

        if(m==p){
            p=0;
        }
        for(int i=0; i<all.length(); i++){
            if(answer.length() == t){
                break;
            }
            if((i+1)%m == p){
                answer += all.charAt(i);
            }
        }
        System.out.println(all);
        System.out.println(answer.toUpperCase());
    }
}