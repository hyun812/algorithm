function solution(s, skip, index) {
    var answer = '';
    
    for(const str of s){
        let num = str.charCodeAt(0);
        
        for(let i=0; i<index; i++){
            num++;
            
            if(num > 122) num = 97;
            
            while(skip.includes(String.fromCharCode(num))){
                num++;
                if(num > 122) num = 97;
            }
        }
        answer += String.fromCharCode(num);
    }
    return answer;
}