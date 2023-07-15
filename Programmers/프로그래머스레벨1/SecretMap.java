package 프로그래머스레벨1;

import java.util.Arrays;

//레벨1 - 비밀지도
public class SecretMap {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};

        String[] Conv_arr1 = new String[n];
        String[] Conv_arr2 = new String[n];
        String[] answer = new String[n];

        for(int i=0; i<arr1.length; i++){
            Conv_arr1[i] = Integer.toBinaryString(arr1[i]);
            if(Conv_arr1[i].length() != n){
                Conv_arr1[i] = leftPadding(Conv_arr1[i], n);
            }
        }

        for(int i=0; i<arr1.length; i++){
            Conv_arr2[i] = Integer.toBinaryString(arr2[i]);
            if(Conv_arr2[i].length() != n){
                Conv_arr2[i] = leftPadding(Conv_arr2[i], n);
            }
        }

        System.out.println(Arrays.toString(Conv_arr1));
        System.out.println(Arrays.toString(Conv_arr2));

        for(int i=0; i<n; i++){
            String a = "";
            for(int j=0; j<n; j++){

                if( Conv_arr1[i].charAt(j) == '1' || Conv_arr2[i].charAt(j) == '1'){
                    a += "#";
                }
                else{
                    a +=" ";
                } 
            }
            answer[i] = a;
            
        }
        System.out.println(Arrays.toString(answer));

    }

    public static String leftPadding(String src, int num) {
		String result = "";

		if (src == null || src.length() >= num) {
			return src;
		}

		int cnt = num - src.length();

		for (int i = 0; i < cnt; i++) {
			result += "0";
		}

		return result + src;
	}
}
