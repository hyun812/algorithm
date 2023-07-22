class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
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
        return answer;
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