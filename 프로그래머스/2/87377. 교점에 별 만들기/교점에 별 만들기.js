function solution(line) {
    const points = [];
    
    for(let i=0; i<line.length; i++){
        for(let j=i; j<line.length; j++){
            const [a,b,e] = line[i];
            const [c,d,f] = line[j];
            
            if(a*d - b*c === 0) continue;
            
            const x = (b*f-e*d) / (a*d-b*c);
            const y = (e*c-a*f) / (a*d-b*c);
            
            if(Number.isInteger(x) && Number.isInteger(y)){
                points.push([x, y]);
            }
        }
    }
    
    let [minX, minY, maxX, maxY] = [Infinity, Infinity, -Infinity, -Infinity];
    
    for(let [x, y] of points){
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
    }
    
    const star = Array.from(Array(maxY - minY + 1), () => Array(maxX - minX + 1).fill("."));

    for (let [x, y] of points) {
        star[maxY - y][x - minX] = "*";
    }
    return star.map((a) => a.join(""));
}