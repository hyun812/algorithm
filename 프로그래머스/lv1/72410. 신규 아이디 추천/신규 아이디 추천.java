class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^0-9a-z_.-]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        if(new_id.isEmpty()){
            new_id = "a";
        }
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        if(new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }

        while(new_id.length() <= 2){
            char lastc = new_id.charAt(new_id.length()-1);
            new_id += lastc; 
        }
        answer = new_id;
        return answer;
    }
}