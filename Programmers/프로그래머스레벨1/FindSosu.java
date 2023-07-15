package 프로그래머스레벨1;

// 레벨1 - 소수 찾기
public class FindSosu {

    public static void main(String[] args) {
        int n=5;
        int answer = 0;

        for(int i=2; i<=n; i++){
            if(sosu(i)){
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static boolean sosu(int num){
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i ==0){
                return false;
            }
        }
        return true;
    }
}