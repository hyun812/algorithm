package 프로그래머스레벨1;

import java.util.Arrays;
import java.util.Stack;

//레벨1 - [1차] 다트 게임
public class datGame {
    //stack활용
    public static void main(String[] args) {
        String dartResult = "10S1S0S*";
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                if((int)c - '0' == 1 && i+1<dartResult.length()-1 && dartResult.charAt(i+1)=='0'){
                    stack.push(10);
                    i++;                    
                }
                else{
                    stack.push((int)c - '0');
                }
            }
            else{
                int pre = stack.pop();
                if(c == 'D'){
                    pre = pre*pre;
                }
                else if(c == 'T'){
                    pre = pre*pre*pre;
                }
                else if(c == '*'){
                    if(!stack.isEmpty()){
                        int val = stack.pop() * 2;
                        stack.push(val);
                    }
                    pre = pre *2;
                }
                else if(c == '#'){
                    pre = pre * (-1);
                }
                stack.push(pre);
            }
        }
        int sumscore = 0;
        while(!stack.isEmpty()){
            sumscore += stack.pop();
        }
        System.out.println(sumscore);
    }
}

//처음
/*
 * String[] dart = dartResult.split("");

        System.out.println(Arrays.toString(dart));
        
        int option_s = 0;
        int option_u = 0;
        int bonas = 0;
        int dou = 0;
        boolean ck = true;

        for(int i= dart.length-1; i>=0; i--){
            if(dart[i].equals("*")){
                if(option_s == 1){
                    dou = 1;
                }
                option_s = 2;
            }
            else if(dart[i].equals("#")){
                option_u = 1;
            }
            else if(dart[i].equals("S")){
                bonas = 1;
            }
            else if(dart[i].equals("D")){
                bonas = 2;
            }
            else if(dart[i].equals("T")){
                bonas = 3;
            }
            else{
                if(dart[i].equals("0") && i-1>=0 && !dart[i-1].isEmpty()){
                    if(dart[i-1].equals("1")){
                        ck = false;
                        continue;
                    }
                    else{
                        if(option_s !=0){
                            option_s--;
                        }
                        if(option_u != 0){
                            option_u--;
                        }
                    }
                }
                else if(ck){
                    Double pow = Math.pow(Integer.parseInt(dart[i]), bonas);
                    if(option_s !=0){
                        if(dou == 1){
                            pow = pow*4;
                            dou = 0;    
                        }
                        else{
                            pow = pow*2;
                        }
                        option_s--;
                    }
                    if(option_u != 0){
                        pow = pow * -1;
                        option_u--;
                    }
                    result = pow.intValue() + result;    
                }
                else if(!ck){
                    Double pow = Math.pow(10, bonas);
                    if(option_s !=0){
                        if(dou == 1){
                            pow = pow*4;
                            dou = 0;    
                        }
                        else{
                            pow = pow*2;
                        }
                        option_s--;
                    }
                    if(option_u != 0){
                        pow = pow * -1;
                        option_u--;
                    }
                    result = pow.intValue() + result;    
                    ck = true;
                }
            }
        }
        System.out.println(result);   String[] dart = dartResult.split("");

        System.out.println(Arrays.toString(dart));
        
        int option_s = 0;
        int option_u = 0;
        int bonas = 0;
        int dou = 0;
        boolean ck = true;

        for(int i= dart.length-1; i>=0; i--){
            if(dart[i].equals("*")){
                if(option_s == 1){
                    dou = 1;
                }
                option_s = 2;
            }
            else if(dart[i].equals("#")){
                option_u = 1;
            }
            else if(dart[i].equals("S")){
                bonas = 1;
            }
            else if(dart[i].equals("D")){
                bonas = 2;
            }
            else if(dart[i].equals("T")){
                bonas = 3;
            }
            else{
                if(dart[i].equals("0") && i-1>=0 && !dart[i-1].isEmpty()){
                    if(dart[i-1].equals("1")){
                        ck = false;
                        continue;
                    }
                    else{
                        if(option_s !=0){
                            option_s--;
                        }
                        if(option_u != 0){
                            option_u--;
                        }
                    }
                }
                else if(ck){
                    Double pow = Math.pow(Integer.parseInt(dart[i]), bonas);
                    if(option_s !=0){
                        if(dou == 1){
                            pow = pow*4;
                            dou = 0;    
                        }
                        else{
                            pow = pow*2;
                        }
                        option_s--;
                    }
                    if(option_u != 0){
                        pow = pow * -1;
                        option_u--;
                    }
                    result = pow.intValue() + result;    
                }
                else if(!ck){
                    Double pow = Math.pow(10, bonas);
                    if(option_s !=0){
                        if(dou == 1){
                            pow = pow*4;
                            dou = 0;    
                        }
                        else{
                            pow = pow*2;
                        }
                        option_s--;
                    }
                    if(option_u != 0){
                        pow = pow * -1;
                        option_u--;
                    }
                    result = pow.intValue() + result;    
                    ck = true;
                }
            }
        }
        System.out.println(result);   
 */
