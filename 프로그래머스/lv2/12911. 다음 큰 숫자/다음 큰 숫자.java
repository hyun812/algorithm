class Solution {
    public int solution(int n) {
        String n_binary = Integer.toBinaryString(n);
        int n_count = 0;
        
        for(int i=0; i<n_binary.length(); i++){
            if(n_binary.charAt(i) == '1'){
                n_count++;
            }
        }
        
        while(true){
            n++;
            String binary = Integer.toBinaryString(n);
            int result_count = 0;

            for(int i=0; i<binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    result_count++;
                }
            }
            
            if(result_count == n_count){
                return n;
            }
        }
        
    }
}