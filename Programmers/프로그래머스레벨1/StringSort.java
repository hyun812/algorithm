package 프로그래머스레벨1;

import java.util.Arrays;
import java.util.HashMap;

//레벨1 - 문자열 내 마음대로 정렬하기
public class StringSort {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

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
        System.out.println(Arrays.toString(answer));
    }
}
