function solution(land) {
    let answer = 0;
    
    const [n, m] = [land.length, land[0].length];
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    let totalCount = new Array(m).fill(0);
    
    const bfs = (startY, startX) => {
        
        let indexSet = new Set();
        let count = 0;
        const queue = [[startY, startX]];
        indexSet.add(startX);
        
        while(queue.length){
            const [y, x] = queue.shift();
            
            if(land[y][x] === 0) continue;
            count++;
            land[y][x] = 0;
            
            for(let i=0; i<4; i++){
                const ny = dy[i] + y;
                const nx = dx[i] + x;
                
                if(ny<0 || nx<0 || ny>=n || nx>= m) continue;
                if(land[ny][nx] === 0) continue;
                
                queue.push([ny, nx]);
                indexSet.add(nx);
            }
        }
        
        return [count, Array.from(indexSet)];
    }
    
    for(let i=0; i<n; i++){
        for(let j=0; j<m; j++){
            if(land[i][j] === 1){
                const [count, indexArr] = bfs(i, j);

                for(let index of indexArr){
                    totalCount[index] += count;
                }
            }
        }
    }
    
    return Math.max(...totalCount);
}