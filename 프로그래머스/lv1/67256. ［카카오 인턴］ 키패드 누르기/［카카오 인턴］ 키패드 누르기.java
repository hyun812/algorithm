class Solution {
    static int lastL = 10;
    static int lastR = 12;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            int key = numbers[i];
            if(key == 0) key = 11;

            if(key == 1 || key == 4 || key == 7){
                lastL = key;
                answer += "L";
            }
            else if(key == 3 || key == 6 || key == 9){
                lastR = key;
                answer += "R";
            }
            else{
                answer = check(key, answer, hand, lastL, lastR);
            } 
        }
        return answer;
    }
    public static String check(int key, String answer, String hand, int left, int right){
        int[][] dis = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        int key_x = 0;
        int key_y = 0;

        int x = 0;
        int y = 0;

        int left_dis = 0;
        int right_dis = 0;

        for(int i=0; i<dis.length; i++){
            for(int j=0; j<dis[i].length; j++){
                if(key == dis[i][j]){
                    key_x=i;
                    key_y=j;
                }
            }
        }
        for(int i=0; i<dis.length; i++){
            for(int j=0; j<dis[i].length; j++){
                if(left == dis[i][j]){
                    x=i;
                    y=j;
                    left_dis = Math.abs(key_x-x) + Math.abs(key_y-y);
                }
            }
        }
        for(int i=0; i<dis.length; i++){
            for(int j=0; j<dis[i].length; j++){
                if(right == dis[i][j]){
                    x=i;
                    y=j;
                    right_dis = Math.abs(key_x-x) + Math.abs(key_y-y);
                }
            }
        }

        if(left_dis < right_dis){
            lastL = key;
            answer += "L";
        }
        else if(left_dis > right_dis){
            lastR = key;
            answer += "R";
        }
        else if(left_dis == right_dis){
            if(hand.equals("right")){
                lastR = key;
                answer += "R";
            }
            else{
                lastL = key;
                answer += "L";
            }
        }
        return answer;
    }
}