
//레벨2 - 숫자의 표현
public class numbers {
    public static void main(String[] args) {
        int n =15;
        //짝수인데 1. 2로나눈게 짝수이면 1개 2. 2로 나눈게 홀수이면 2개
        //홀수이면
        int answer = 0;
        int i=1;
        
        while(i <= n/2){
            int start = i;
            int sum = 0;

            while(sum < n){
                sum += start;
                start++;
            }
            if(sum == n){
                answer++;
            }
            i++;
        }
        answer++;
        System.out.println(answer);
    }
}
