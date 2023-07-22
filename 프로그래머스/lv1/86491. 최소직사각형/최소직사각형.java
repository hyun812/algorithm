class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = 0;
                temp = sizes[i][0] ;
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        int a = 0;
        int b = 0;

        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > a){
                a = sizes[i][0];
            }
            if(sizes[i][1] > b){
                b = sizes[i][1];
            }
        }
        answer = a*b;
        
        return answer;
    }
}