function solution(ingredient) {
    let answer = 0;
    const stack = [];
    
    for(const item of ingredient){
        stack.push(item);
        
        if(stack.length >= 4) {
            const burger = stack.slice(-4).join("");
            
            if(burger === "1231") {
                stack.splice(-4);
                answer++;
            }
        }
    }
    return answer;
}