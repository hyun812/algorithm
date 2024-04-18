/*
    각 지점에 대해 합승하는 케이스 + 그 위치로 부터 각각 목적지로
*/
function solution(n, s, a, b, fares) {
    let answer = Number.MAX_SAFE_INTEGER;
    
    const road = Array.from({length: n+1}, ()=>Array(n+1).fill(Number.MAX_SAFE_INTEGER));
    
    fares.forEach((value) => {
        const [a, b, c] = value;
        road[a][b]= c;
        road[b][a]= c;
    })
    
    for(let k=1; k<n+1; k++){ // 경유지
        for(let i=1; i<n+1; i++){ // 출발지 
            for(let j=1; j<n+1; j++){ // 도착지
                if(i==j){
                    road[i][j] = 0;
                    continue;
                }
                
                if(road[i][j] > road[i][k] + road[k][j]){
                    road[i][j] = road[i][k] + road[k][j];   
                }
            }
        }
    }
    
    for(let i=1; i<n+1; i++){
        answer = Math.min(answer, road[s][i] + road[i][a] + road[i][b]);    
    }
    
    
    
    return answer;
}