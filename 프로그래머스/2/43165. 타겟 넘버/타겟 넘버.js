function solution(numbers, target) {
    var answer = 0;
    
    const dfs = (num, i) => {        
        if (i === numbers.length) {
            if (target === num) answer++;
            return;
        }
        
        dfs(num + numbers[i], i + 1);
        dfs(num - numbers[i], i + 1);
    }
    
    dfs(0, 0);
    
    return answer;
}