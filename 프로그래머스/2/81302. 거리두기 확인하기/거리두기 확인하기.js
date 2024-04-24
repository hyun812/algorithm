function solution(places) {
    const dy = [-1,1,0,0];
    const dx = [0,0,-1,1];
    
    const check = (arr, y, x) => {
        
        for(let i=0; i<4; i++){
            const ny = y+dy[i];
            const nx = x+dx[i];

            if(ny<0 || nx<0 || ny>=5 || nx>=5) continue;
            if(arr[ny][nx] === 'P') return false;
            
            if(arr[ny][nx] === "O"){
                
                for(let j=0; j<4; j++){
                    const nny = ny+dy[j];
                    const nnx = nx+dx[j];
                    
                    if(nny<0 || nnx<0 || nny>=5 || nnx>=5) continue;
                    if (nnx === x && nny === y) continue;
                    if (arr[nny][nnx] === "P") return false
                
                }
            }
        }
        return true;
    }
    const answer = [];
    for(let i=0; i<5; i++){
            
        const arr = places[i];
        let isSafe = 1;
        for(let j=0; j<arr.length; j++){
            for(let k=0; k<arr[0].length; k++){
                if(arr[j][k] !== 'P') continue;
                
                if(!check(arr, j, k)){
                    isSafe = 0;
                    break;
                }
            }
            
            if(isSafe === 0){
                break;
            }
        }
        answer.push(isSafe);
    }
        
    return answer;
}