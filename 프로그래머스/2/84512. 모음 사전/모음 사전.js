function solution(word) {
    let answer = 0;
    let cnt = 0;
    
    const order = ["A", "E", "I", "O", "U"];
    
    const dfs = (str) => {
        if (str === word) return true;
        if (str.length >= 5) return false;
        
        for (const char of order) {
            cnt++;
            if (dfs(str + char)) {
                answer = cnt;
                return true;
            }
        }
        return false;
    }
    
    dfs("")
    
    return answer;
}