function solution(numbers) {
    let answer = 0;
    const visited = Array(numbers.length).fill(0);
    const check = new Set();
    
    const sosu = (num) => {
        if (num === 2) return true;
        
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) return false;
        }
        return true;
    }
    
    const dfs = (cur, count) => {
        if (count === numbers.length) {
            const num = Number(cur);
            if (num <= 1 || check.has(num)) return;
            check.add(num);
            
            if (sosu(num)) answer++;
            return;
        }
        
        for (let i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = 1;
            dfs(cur + numbers[i], count + 1);
            visited[i] = 0;
            dfs(cur, count + 1);
        }
    }
    
    dfs("", 0);
    
    return answer;
}