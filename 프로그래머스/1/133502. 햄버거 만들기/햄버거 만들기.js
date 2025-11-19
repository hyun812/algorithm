function solution(ingredient) {
    let answer = 0;
    const stack = [];
    
    const checkAndRemoveBurger = () => {
        if (stack.length >= 4 && stack.slice(-4).join('') === '1231') {
            stack.splice(-4, 4);
            answer++;
        }
    }
    
    for (let i = 0; i < ingredient.length; i++) {
        stack.push(ingredient[i]);
        checkAndRemoveBurger();
    }
    
    checkAndRemoveBurger();
    
    return answer;
}