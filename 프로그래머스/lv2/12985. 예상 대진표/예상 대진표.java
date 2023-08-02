class Solution
{
    public int solution(int n, int a, int b)
    {
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

        return answer;
    }
}