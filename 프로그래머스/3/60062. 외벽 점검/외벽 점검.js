const permutaion = (arr, n) => {
    if(n===1) return arr.map(v => [v]);
    
    const result = [];
    
    arr.forEach((fixed, idx, origin) => {
        const rest = [...origin.slice(0, idx), ...origin.slice(idx+1)];
        const perms = permutaion(rest, n-1);
        const attached = perms.map((perm)=>[fixed, ...perm]);
        result.push(...attached);
    })
    
    return result;
}


function solution(n, weak, dist) {
    const len = weak.length;
    const weakArr = [...weak, ...weak.map((v) => v + n)]; // 이동방향 고정
    
    dist.sort((a,b) => b-a);
    
    for(let i=1; i<=dist.length; i++){
        const permut = permutaion(dist, i); // 순열 탐색
        
        for(const perm of permut){ // i인원으로 접근 가능한 경우의 수
            
            for(let j=0; j<len; j++){
                let line = weakArr.slice(j, len+j); // 순차적으로 접근 가능한 경로
                
                for(const p of perm){ // 각 인원의 작업 거리
                    const cover = line[0] + p; // 커버할 수 있는 범위
                    line = line.filter((e) => e > cover); // 커버 불가능한 지점만 남김
                    
                    if(!line.length) return i;
                }       
            }    
        }
    }
    
    
    return -1;
}