function solution(n) {
    let answer = 0;
    const queens = [];
    
    const check = (checkY, checkX) => {
        for (const [y, x] of queens) {
            if (checkY === y || checkX === x) return false;
            if (Math.abs(checkY - y) === Math.abs(checkX - x)) return false;
        }
        return true
    }
    
    const dfs = (y) => {
        if (y === n) {
            answer++;
            return;
        }
        
        for (let x = 0; x < n; x++) {
            if (!check(y, x)) continue;
            queens.push([y, x]);
            dfs(y + 1);
            queens.pop();
        }   
    }
    
    dfs(0);
    
    return answer;
}