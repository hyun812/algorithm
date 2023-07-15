package 프로그래머스레벨1;

import java.util.regex.Pattern;

//레벨1 - 신규 아이디 추천
public class newId {
    public static void main(String[] args) {
        String new_id = "=.=";
        //...bat..y.abcdefghijklm
        //...!@bat#*..y.abcdefghijklm
        
        //1단계 소문자로
        new_id = new_id.toLowerCase();
        System.out.println(new_id);

        //2단계 문자 제거
        new_id = new_id.replaceAll("[^0-9a-z_.-]", "");
        System.out.println(new_id);

        //3단계 ... > .
        new_id = new_id.replaceAll("[.]{2,}", ".");
        System.out.println(new_id);

        //4단계 처음위치 . 제거 / 끝위치 . 제거
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        System.out.println(new_id);
        if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        System.out.println(new_id);

        //5단계 빈문자열이면 a대입
        if(new_id.isEmpty()){
            new_id = "a";
        }
        System.out.println(new_id);

        //6단계 길이 16자 이상이면 첫 15개 제외 나머지 없앰
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        //만약 제거후 .가 끝에 위치하면 . 제거
        if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        //7단계 2자 이하라면 길이 반복해서 늘림
        while(new_id.length() <= 2){
            char lastc = new_id.charAt(new_id.length()-1);
            new_id += lastc; 
        }

        System.out.println(new_id);
    }
}
