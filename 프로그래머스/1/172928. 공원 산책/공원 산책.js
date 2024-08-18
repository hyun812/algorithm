function solution(park, routes) {
    let [y, x] = [-1, -1];
    
    for(let i=0; i<park.length; i++){
        if(park[i].includes('S')) {
            [y, x] = [i, park[i].indexOf('S')];    
        }
    }
    const dirs = { N: [-1, 0], S: [1, 0], W: [0, -1], E: [0, 1]};
    routes.forEach((route) => {
        const [r, n] = route.split(" ");
        
        let [copyY, copyX] = [y, x];
        let isOK = true;
        
        for(let i=0; i<n; i++){
            const ny = y+dirs[r][0];
            const nx = x+dirs[r][1];
            
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