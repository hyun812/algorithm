function solution(s) {
    const answer = s.map((word) => {
        const stack = [];
        let str = '';
        
        for (const c of word) {
            if (stack.length > 1) {
                const b = stack.pop();
                const a = stack.pop();
                
                if(a + b + c === '110') {
                    str += '110';
                } else {
                    stack.push(a, b, c);
                }
            } else {
                stack.push(c);
            }          
        }
        
        const base = stack.join('');
        const lastZero = base.lastIndexOf("0");
        
        return lastZero === -1 ? str + base : base.slice(0, lastZero + 1) + str + base.slice(lastZero + 1);
    })
    return answer;
}