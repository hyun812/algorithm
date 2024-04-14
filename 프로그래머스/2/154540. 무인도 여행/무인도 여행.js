// x는 바다 숫자는 무인도 (1~9)
// 상하좌우 숫자합이 무인도에 머무를 수 있는 날짜
// 각 섬에서 최대 며칠을 머무를 수 있는지 오름차순으로 

function solution(maps) {
    const answer = [];
    
    const visited = Array.from({ length: maps.length }, ()=> Array(maps[0].length).fill(0));
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    
    const check = (a, b) =>{
        let cnt = parseInt(maps[a][b]);
        const queue = [[a, b]];
        visited[a][b] = 1;
        
        while(queue.length){
            const [y, x] = queue.shift();
            
            for(let i=0; i<4; i++){
                const ny = y+dy[i];
                const nx = x+dx[i];
                
                if(ny<0 || nx<0 || ny>=maps.length || nx>=maps[0].length) continue; // 배열 범위를 벗어난다면
                if(visited[ny][nx]) continue; // 이미 방문했던적이 있다면
                if(maps[ny][nx] === 'X') continue; // 바다라면
                
                visited[ny][nx] = 1; // 방문처리
                queue.push([ny, nx]); // queue에 추가
                cnt += parseInt(maps[ny][nx]);
            }
        }
        return cnt;
    }
    
    
    for(let i=0; i<maps.length; i++){
        for(let j=0; j<maps[0].length; j++){
            if(!visited[i][j] && maps[i][j] !== "X"){
                answer.push(check(i, j));
            }
        }
    }
    
    return answer.length ? answer.sort((a, b) => a-b) : [-1];
}