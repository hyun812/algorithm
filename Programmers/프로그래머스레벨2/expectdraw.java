
//레벨2 - 예상 대진표
public class expectdraw {
    public static void main(String[] args) {
        int N = 8;
        int a = 4;
        int b = 7;

        int answer =  0;
        while(true){
            if(a%2 == 0){
                if(a-1 == b){
                    answer++;
                    break;
                }
                else{
                    a = a/2;
                    if(b%2 ==0){
                        b = b/2;
                    }
                    else b = b/2+1;
                    answer++;
                }
            }
            else if(a%2 != 0){
                if(a+1 == b){
                    answer++;
                    break;
                }
                else{
                    a = a/2+1;
                    if(b%2 ==0){
                        b = b/2;
                    }
                    else b = b/2+1;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
