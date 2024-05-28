function solution(n) {
    let answer = 0;
    
    const arr = [];
    
    const check = (x, y) => {
        for(const [a, b] of arr){
            if(a === x || b === y) return false;
            if(Math.abs(a-x) === Math.abs(b-y)) return false;       
        }
        
        return true;
    }
    
    const dfs = (row) => {
        if(row === n){
            answer++;
            return;
        }
        
        for(let i=0; i<n; i++){
            if(!check(row, i)) continue;
            arr.push([row, i]);
            dfs(row+1);
            arr.pop();
        }
    }
    
    dfs(0);
    
    return answer;
}