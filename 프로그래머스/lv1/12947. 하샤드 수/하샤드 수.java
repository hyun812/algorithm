class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] ss = String.valueOf(x).split("");
        int sum = 0;
        
        for(String s : ss){
            sum += Integer.parseInt(s);
        }
        
        if(x % sum != 0){
            answer = false;
        }
        return answer;
    }
}