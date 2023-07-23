import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        char[] charArr = new char[strings.length];
        for(int i=0; i<strings.length; i++){
            charArr[i] = strings[i].charAt(n);
        }
        System.out.println(Arrays.toString(charArr));
        Arrays.sort(charArr);
        
        String[] answer = new String[strings.length];

        for(String s : strings){
            for(int i=0; i<charArr.length; i++){
                if(answer[i] != null){
                    continue;
                }
                if(s.charAt(n) == charArr[i]){
                    answer[i] = s;
                    break;
                }
            }
        }
        return answer;
    }
}