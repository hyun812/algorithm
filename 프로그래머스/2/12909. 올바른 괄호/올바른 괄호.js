function solution(s){
    const stack = [];
    
    for (const char of s) {
        if (char === '(') {
            stack.push(char);   
        }else {
            if (stack.length && stack[stack.length - 1] === '(') {
                stack.pop();
            }else {
                return false;
            }
        }
    }
    return stack.length ? false : true;
}