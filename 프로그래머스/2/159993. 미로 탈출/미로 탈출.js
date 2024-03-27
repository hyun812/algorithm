function solution(maps) {
    let answer = 0;
    
    [startY, startX] = [0 , 0];
    [endY, endX] = [0 , 0];
    [leverY, leverX] = [0, 0];
    
    const map = Array.from({length: maps.length}, () => Array(maps[0].length).fill(0));
 
    for(let i=0; i<maps.length; i++){
        for(let j=0; j<maps[0].length; j++){
            map[i][j] = maps[i][j];
            
            if(map[i][j] === "S"){
                startY = i;
                startX = j;
            }else if(map[i][j] === "E"){
                endY = i;
                endX = j;
            }else if(map[i][j] === 'L'){
                leverY = i;
                leverX = j;
            }
        }
    }
    
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    
    const bfs = (y, x, endy, endx) => {
        const visited = Array.from({length: maps.length}, () => Array(maps[0].length).fill(0));    
        const q = [[y, x, 0]];
        visited[y][x] = 1;
        
        console.log(visited);
        while(q.length){
            const [y, x, len] = q.shift();
            
            if(endy === y && endx === x){
                return len;
            }
            
            for(let i=0; i<4; i++){
                let ny = y + dy[i];
                let nx = x + dx[i];

                if(ny<0 || nx<0 || ny>=maps.length || nx>=maps[0].length) continue;
                if(visited[ny][nx] == 1) continue;
                if(map[ny][nx] === "X") continue;
                
                visited[ny][nx] = 1;
                q.push([ny, nx , len+1]);
            }
        }    
    }
    
    const lever = bfs(startY, startX, leverY, leverX);
    const end = bfs(leverY, leverX, endY, endX);
    
    console.log(lever);
    console.log(end);
    
    
    return lever && end ? lever+end : -1;
}