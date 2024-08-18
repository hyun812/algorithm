function solution(park, routes) {
    let [y, x] = [-1, -1];
    
    for(let i=0; i<park.length; i++){
        for(let j=0; j<park[0].length; j++){
            if(park[i][j] === 'S'){
                y = i;
                x = j;
            }
        }
        if(y !== -1 && x !== -1) break;
    }
    
    const dirToIndex = (dir) => {
        let index = -1;
        switch(dir) {
            case "N" :
                index = 0;
                break;
            case "S" :
                index = 1;
                break;
            case "W" :
                index = 2;
                break;
            case "E" :
                index = 3;
                break;
        }
        return index;
    }

    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1]
    routes.forEach((route) => {
        const [dir, count] = route.split(" ");
        
        const idx = dirToIndex(dir);
        let [copyY, copyX] = [y, x];
        let isOK = true;
        
        for(let i=0; i<count; i++){
            const ny = y+dy[idx];
            const nx = x+dx[idx];
            
            if(ny < 0 || nx < 0 || ny >= park.length || nx >= park[0].length || park[ny][nx] === "X") {
                isOK = false;
                break;
            }
            
            [y, x] = [ny, nx];
        }
        
        if(!isOK){
            [y, x] = [copyY, copyX];   
        }
    })
    
    return [y, x];
}