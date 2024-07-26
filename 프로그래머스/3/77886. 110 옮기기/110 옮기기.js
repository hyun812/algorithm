function solution(s) {
    
    let answer = s.map((v) => {
        const stack = [];
        let str = "";
        
        for(const c of v){
            if(stack.length > 1){
                const b = stack.pop();
                const a = stack.pop();
                
                `${a}${b}${c}` === "110" ? (str += "110") : stack.push(a, b, c);
            }else {
                stack.push(c);
            }
        }
        
        const base = stack.join("");
        const zeroIdx = base.lastIndexOf("0");
        
        return zeroIdx === -1 ? str+base : base.slice(0, zeroIdx+1) + str + base.slice(zeroIdx+1);
    })
    
    return answer;
}