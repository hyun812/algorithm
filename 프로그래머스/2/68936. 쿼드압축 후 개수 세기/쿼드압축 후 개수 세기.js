function solution(arr) {
    const answer = [0, 0];
    
    const check = (x, y, n) => {
        const target = arr[x][y];
        
        if(n === 1){
            answer[target]++;
            return;
        }
        
        let flag = true;
        for(let i=x; i<x+n; i++){
            for(let j=y; j<y+n; j++){
                if(target !== arr[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        
        // 하나로 압축할 수 있다면
        if(flag) return answer[target]++;
        
        // 그게 아니라면 4분할
        n/=2;
        
        check(x, y, n);
        check(x+n, y, n);
        check(x, y+n, n);
        check(x+n, y+n, n);
    }
    
    check(0, 0, arr.length);
    
    return answer;
}