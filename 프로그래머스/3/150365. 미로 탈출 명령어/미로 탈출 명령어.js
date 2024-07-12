// 거리가 k여야 함
// 같은 격자를 다시 방문해도 됨
// 문자열 사전 순으로 정렬
const str = {
    0 : "d",
    1 : "l",
    2 : "r",
    3 : "u",
}

function solution(n, m, x, y, r, c, k) {
    let answer = '';
    
    const arr = Array.from({length: n}, ()=> Array(m).fill("."));
    arr[x-1][y-1] = "S";
    arr[r-1][c-1] = "E";
    
    // d, l, r, u (사전순)
    const dx = [1, 0, 0, -1];
    const dy = [0, -1, 1, 0];
    
    let fast = k - (Math.abs(x - r) + Math.abs(y - c));
    if (fast < 0 || fast % 2 != 0) return "impossible";
    
    const dfs = (cur, path) => {
        if(answer) return; // 젤 처음 도착한 경로가 사전 순으로 빠른 경로이므로
        if(path.length > k) return;
        
        const [nx, ny] = cur;
        
        // 남은 최소 거리 + 현재 온 거리가 k보다 크다면
        if(Math.abs(nx-(r-1) + Math.abs(ny-(c-1)) + path.length > k)){ 
            return;
        }
        
        // k만큼 이동하여 도착지점에 왔다면
        if(path.length === k && nx === r-1 && ny === c-1){
            answer = path;
            return;
        }
        
        for(let i=0; i<4; i++){
            const nnx = nx + dx[i];
            const nny = ny + dy[i];
            
            if(nnx<0 || nny<0 || nnx>=n || nny>=m) continue;
            
            dfs([nnx, nny], path+str[i]);
        }
        
    }
    
    dfs([x-1, y-1], "");
    
    return answer;
}