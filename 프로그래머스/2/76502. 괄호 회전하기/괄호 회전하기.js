function solution(s) {
    let answer = 0;
    
    let stack = [];
  
    if (s.length % 2 === 1) return 0;
    
    for(let i = 0; i < s.length; i++){       
        let str = s.slice(i) + s.slice(0,i);
        let isPossible = true;
      
        for(const n of str){
            if(n === "[" || n === "{" || n === "(" ){
                stack.push(n);
            }else{
                let pop = stack.pop();
                
                if (pop === "(" && n === ")") continue;
                if (pop === "{" && n === "}") continue;
                if (pop === "[" && n === "]") continue;

                isPossible = false;
                break;
            };
        };
        if (isPossible) answer++;
    };
    return answer;
};