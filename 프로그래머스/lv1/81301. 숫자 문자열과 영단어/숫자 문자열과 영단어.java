class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] word = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i< word.length; i++){
            if(s.contains(word[i])){
                s = s.replaceAll(word[i],  Integer.toString(i));
            }
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}