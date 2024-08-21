function solution (n) {
    let answer = 0;
    
    const dfs = (open, close) => {
        if(open+close === n*2){
            if(open === n && close === n) answer++;
            return;
        }
        
        if(open > close){
            dfs(open, close+1);
        }
        dfs(open+1, close);
        return;
    }
    
    dfs(0, 0);
  
    return answer; 
}