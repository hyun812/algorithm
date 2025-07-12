function solution(topping) {
    let answer = 0;
    const len = topping.length;
    
    const a = new Map();
    const b = new Map();
    
    a.set(topping[0], 1);
    for (let i = 1; i < len; i++) {
        b.set(topping[i], (b.get(topping[i]) || 0) + 1);
    }
    
    if (a.size === b.size) answer++;
    
    for (let i = 1; i < len - 1; i++) {
        a.set(topping[i], (a.get(topping[i]) || 0) + 1);
        
        if (b.get(topping[i]) === 1) {
            b.delete(topping[i]);
        }else {
            b.set(topping[i], (b.get(topping[i])) - 1);    
        }
        
        if (a.size === b.size) answer++;
    }
    return answer;
}